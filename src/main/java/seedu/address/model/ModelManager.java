package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.plan.Date;
import seedu.address.model.plan.PlannedRecipeMap;
import seedu.address.model.recipe.Recipe;

/**
 * Represents the in-memory model of the recipe book data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final RecipeBook recipeBook;
    private final UserPrefs userPrefs;
    private final FilteredList<Recipe> filteredRecipes;
    private final VersionedRecipeBook states;
    private final PlannedRecipeMap plannedRecipes;

    /**
     * Initializes a ModelManager with the given recipeBook and userPrefs.
     */
    public ModelManager(ReadOnlyRecipeBook recipeBook, ReadOnlyUserPrefs userPrefs) {
        super();
        requireAllNonNull(recipeBook, userPrefs);

        logger.fine("Initializing with recipe book: " + recipeBook + " and user prefs " + userPrefs);

        this.recipeBook = new RecipeBook(recipeBook);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredRecipes = new FilteredList<>(this.recipeBook.getRecipeList());
        this.states = new VersionedRecipeBook(recipeBook);
        plannedRecipes = new PlannedRecipeMap(); // todo: planned recipes cant be saved currently
    }

    public ModelManager() {
        this(new RecipeBook(), new UserPrefs());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getRecipeBookFilePath() {
        return userPrefs.getRecipeBookFilePath();
    }

    @Override
    public void setRecipeBookFilePath(Path recipeBookFilePath) {
        requireNonNull(recipeBookFilePath);
        userPrefs.setRecipeBookFilePath(recipeBookFilePath);
    }

    //=========== RecipeBook ================================================================================

    @Override
    public void setRecipeBook(ReadOnlyRecipeBook recipeBook) {
        this.recipeBook.resetData(recipeBook);
    }

    @Override
    public ReadOnlyRecipeBook getRecipeBook() {
        return recipeBook;
    }

    @Override
    public boolean hasRecipe(Recipe recipe) {
        requireNonNull(recipe);
        return recipeBook.hasRecipe(recipe);
    }

    @Override
    public void deleteRecipe(Recipe target) {
        recipeBook.removeRecipe(target);
    }

    @Override
    public void favouriteRecipe(Recipe target) {
        recipeBook.favouriteRecipe(target);
    }

    @Override
    public void unfavouriteRecipe(Recipe target) {
        recipeBook.unfavouriteRecipe(target);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        recipeBook.addRecipe(recipe);
        updateFilteredRecipeList(PREDICATE_SHOW_ALL_RECIPES);
    }

    @Override
    public void setRecipe(Recipe target, Recipe editedRecipe) {
        requireAllNonNull(target, editedRecipe);
        recipeBook.setRecipe(target, editedRecipe);
    }

    @Override
    public boolean canUndo(int numberOfUndo) {
        return states.canUndo(numberOfUndo);
    }

    @Override
    public boolean canRedo(int numberOfRedo) {
        return states.canRedo(numberOfRedo);
    }

    @Override
    public void commitRecipeBook() {
        states.commit(new RecipeBook(recipeBook));
    }

    @Override
    public void undoRecipeBook(int numberOfUndo) {
        setRecipeBook(states.undo(numberOfUndo));
    }

    @Override
    public void redoRecipeBook(int numberOfRedo) {
        setRecipeBook(states.redo(numberOfRedo));
    }

    //=========== Filtered Recipe List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Recipe} backed by the internal list of
     * {@code versionedRecipeBook}
     */
    @Override
    public ObservableList<Recipe> getFilteredRecipeList() {
        return filteredRecipes;
    }

    @Override
    public void updateFilteredRecipeList(Predicate<Recipe> predicate) {
        requireNonNull(predicate);
        filteredRecipes.setPredicate(predicate);
    }

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ModelManager)) {
            return false;
        }

        // state check
        ModelManager other = (ModelManager) obj;
        return recipeBook.equals(other.recipeBook)
                && userPrefs.equals(other.userPrefs)
                && filteredRecipes.equals(other.filteredRecipes);
    }

    //=========== Planned Recipe List Accessors =============================================================

    @Override
    public void planRecipe(Recipe recipeToSet, Date atDate) {
        plannedRecipes.add(recipeToSet, atDate);
    }

}
