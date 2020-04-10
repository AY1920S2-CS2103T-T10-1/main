package seedu.recipe.model;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.recipe.commons.core.GuiSettings;
import seedu.recipe.logic.commands.CommandType;
import seedu.recipe.model.achievement.Quote;
import seedu.recipe.model.cooked.Record;
import seedu.recipe.model.goal.GoalCount;
import seedu.recipe.model.plan.PlannedDate;
import seedu.recipe.model.plan.PlannedRecipeMap;
import seedu.recipe.model.recipe.Recipe;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Recipe> PREDICATE_SHOW_ALL_RECIPES = unused -> true;

    /** {@code Predicate} that always evaluate to true */
    Predicate<PlannedDate> PREDICATE_SHOW_ALL_PLANNED_RECIPES = unused -> true;

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
    void commitBook(CommandType commandType);

    /**
     * Reverts the RecipeBook back by {@code numberOfUndo} states.
     */
    void undoBook(int numberOfUndo, Model model);

    /**
     * Fast forwards the RecipeBook by {@code numberOfRedo} states.
     */
    void redoBook(int numberOfRedo, Model model);

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
     * Replaces the data in the planned book with data from {@code plannedBook}.
     */
    void setPlannedBook(ReadOnlyPlannedBook plannedBook);

    /**
     *  todo change
     */
    void addToExistingPlan(Recipe recipe, PlannedDate oldPlans, PlannedDate newPlans);

    /**
     * Adds the {@code newPlan} that plans for {@code recipe}.
     */
    void addNewPlan(Recipe recipe, PlannedDate newPlan);

    /**
     * Deletes the {@code recipe} plan from the {@code plannedDate}.
     */
    void deleteOnePlan(Recipe recipe, PlannedDate plannedDate);

    /**
     * Returns an unmodifiable view of the planned recipes.
     */
    ObservableList<PlannedDate> getFilteredPlannedList();

    /**
     * Updates the filtered planned list to be filtered using the {@code predicate}.
     */
    void updateFilteredPlannedList(Predicate<PlannedDate> predicate) throws NullPointerException;

    /**
     * Returns the mapping of recipes to planned dates.
     */
    PlannedRecipeMap getPlannedMap();

    /**
     * Returns the list of plans that uses {@code recipe}.
     */
    List<PlannedDate> getPlans(Recipe recipe);

    /**
     * Returns the grocery list containing all the ingredients in the planned recipes.
     */
    String getGroceryList();

    /**
     * Sets the grocery list containing all the ingredients in the planned recipes.
     */
    void setGroceryList(String groceryList);

    /**
     * Adds a record in the cookedRecord list
     */
    void addRecord(Record record);

    /** Returns an unmodifiable view of the filtered record list */
    ObservableList<Record> getFilteredRecordList();

    /**
     * Updates goal tally every time a record is added
     * @code record
     */
    void updateGoalsTally(Record record);

    /** Returns an unmodifiable view of the filtered goals list */
    ObservableList<GoalCount> getFilteredGoalsTally();

    /**
     * Replaces record book data with the data in {@code CookedRecordBook}.
     */
    ReadOnlyCookedRecordBook getRecordBook();

    /**
     * Returns true if a record with the same identity as {@code record} exists in the record book.
     */
    boolean hasRecord(Record record);

<<<<<<< HEAD
=======
    /**
     * Replaces quotelist data with the data in {@code quotes}.
     */
    ObservableList<Quote> getFilteredQuoteList();

    /**
     * Replaces quote book data with the data in {@code CQuoteBook}.
     */
    ReadOnlyQuoteBook getQuoteBook();

    /**
     * Returns true if a quote with the same identity as {@code quote} exists in the quote book.
     */
    boolean hasQuote(Quote quote);
>>>>>>> master
}
