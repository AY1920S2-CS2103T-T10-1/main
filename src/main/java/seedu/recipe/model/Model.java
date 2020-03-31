package seedu.recipe.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.recipe.commons.core.GuiSettings;
import seedu.recipe.model.cooked.Record;
import seedu.recipe.model.plan.PlannedRecipe;
import seedu.recipe.model.plan.ReadOnlyPlannedBook;
import seedu.recipe.model.recipe.Recipe;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Recipe> PREDICATE_SHOW_ALL_RECIPES = unused -> true;

    /** {@code Predicate} that always evaluate to true */
    Predicate<PlannedRecipe> PREDICATE_SHOW_ALL_PLANNED_RECIPES = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' recipe book file path.
     */
    Path getRecipeBookFilePath();

    /**
     * Sets the user prefs' recipe book file path.
     */
    void setRecipeBookFilePath(Path recipeBookFilePath);

    /**
     * Replaces recipe book data with the data in {@code recipeBook}.
     */
    void setRecipeBook(ReadOnlyRecipeBook recipeBook);

    /** Returns the RecipeBook */
    ReadOnlyRecipeBook getRecipeBook();

    /**
     * Returns true if a recipe with the same identity as {@code recipe} exists in the recipe book.
     */
    boolean hasRecipe(Recipe recipe);

    /**
     * Deletes the given recipe.
     * The recipe must exist in the recipe book.
     */
    void deleteRecipe(Recipe target);

    /**
     * Favourites the given recipe.
     * The recipe must exist in the recipe book.
     */
    void favouriteRecipe(Recipe target);

    /**
     * Unfavourites the given recipe.
     * The recipe must exist in the recipe book.
     */
    void unfavouriteRecipe(Recipe target);

    /**
     * Adds the given recipe.
     * {@code recipe} must not already exist in the recipe book.
     */
    void addRecipe(Recipe recipe);

    /**
     * Replaces the given recipe {@code target} with {@code editedRecipe}.
     * {@code target} must exist in the recipe book.
     * The recipe identity of {@code editedRecipe} must not be the same as another existing recipe in the recipe book.
     */
    void setRecipe(Recipe target, Recipe editedRecipe);

    /**
     * Checks if it is possible to undo. Returns true if there is at least {@code numberOfUndo} older states
     * of the RecipeBook (relative to the current state) being stored.
     */
    boolean canUndo(int numberOfUndo);

    /**
     * Checks if it is possible to redo. Returns true if there is at least {@code numberOfRedo} newer states
     * of the RecipeBook (relative to the current state) being stored.
     */
    boolean canRedo(int numberOfRedo);

    /**
     * Stores the new state of the RecipeBook when the RecipeBook undergoes a state change.
     */
    void commitRecipeBook();

    /**
     * Reverts the RecipeBook back by {@code numberOfUndo} states.
     */
    void undoRecipeBook(int numberOfUndo);

    /**
     * Fast forwards the RecipeBook by {@code numberOfRedo} states.
     */
    void redoRecipeBook(int numberOfRedo);

    /** Returns the PlannedBook */
    ReadOnlyPlannedBook getPlannedBook();

    /** Returns an unmodifiable view of the filtered recipe list */
    ObservableList<Recipe> getFilteredRecipeList();

    /**
     * Updates the filter of the filtered recipe list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredRecipeList(Predicate<Recipe> predicate);

    /**
     * Adds a planned recipe to the plannedRecipe list
     */
    void addPlannedRecipe(PlannedRecipe plannedRecipe);

    /**
     * Adds a {@code plannedRecipe} to the {@code recipe} key in the Recipe to PlannedRecipe map.
     */
    void addPlannedMapping(Recipe recipe, PlannedRecipe plannedRecipe);

    /**
     * Removes all PlannedRecipe mapped to the {@code recipe} key.
     */
    void removeAllPlannedMappingForRecipe(Recipe recipe);

    /**
     * Replaces the {@code target} Recipe with the {@code editedRecipe} Recipe in the
     * mapping from Recipe to PlannedRecipe map.
     * Updates the references to Recipe in each PlannedRecipe.
     */
    void setPlannedRecipe(Recipe target, Recipe editedRecipe);

    /**
     * Returns an unmodifiable view of the planned recipes.
     */
    ObservableList<PlannedRecipe> getFilteredPlannedList();


    /**
     * Updates the filtered planned list to be filtered using the {@code predicate}.
     * todo throw exception?
     */
    void updateFilteredPlannedList(Predicate<PlannedRecipe> predicate);

    //updateAndFillPlannedList todo

    /**
     * Adds a record in the cookedRecord list
     */
    void addRecord(Record record);

    /** Returns an unmodifiable view of the filtered record list */
    ObservableList<Record> getFilteredRecordList();

    /**
     * Replaces record book data with the data in {@code CookedRecordBook}.
     */
    ReadOnlyCookedRecordBook getRecordBook();

    /**
     * Returns true if a record with the same identity as {@code record} exists in the record book.
     */
    boolean hasRecord(Record record);

}
