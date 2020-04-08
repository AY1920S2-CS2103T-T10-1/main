package seedu.recipe.model.plan;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import seedu.recipe.model.ReadOnlyPlannedBook;
import seedu.recipe.model.recipe.Recipe;

/**
 * Wraps all data at the planned-recipe-book level
 * Duplicates are not allowed (by .isSameRecipe comparison)
 */
public class PlannedBook implements ReadOnlyPlannedBook {

    private final UniquePlannedList plannedDates;
    private final PlannedRecipeMap recipeMap;

    public PlannedBook() {
        plannedDates = new UniquePlannedList();
        recipeMap = new PlannedRecipeMap();
    }

    /**
     * Creates a PlannedBook using the planned recipes in the {@code toBeCopied}
     */
    public PlannedBook(ReadOnlyPlannedBook toBeCopied) {
        this();
        resetData(toBeCopied);
    }


    /**
     * Replaces the contents of the planned recipe list with {@code plannedDates}.
     * {@code plannedDates} must not contain duplicate recipes on the same day.
     */
    public void setPlannedDates(ObservableList<PlannedDate> plannedDates) {
        this.plannedDates.setPlannedDates(plannedDates);
    }

    /**
     * Replaces the contents of the recipe map with {@code plannedRecipeMap}.
     */
    public void setRecipeMap(PlannedRecipeMap recipeMap) {
        this.recipeMap.setPlannedRecipeMap(recipeMap);
    }

    /**
     * Resets the existing data of this {@code PlannedBook} with {@code newData}.
     */
    public void resetData(ReadOnlyPlannedBook newData) {
        requireNonNull(newData);

        setPlannedDates(newData.getPlannedList());
        setRecipeMap(newData.getPlannedMap());
    }

    // ===== PlannedDate and Recipe level methods =====

    /**
     * Checks whether the planned book contains {@code plannedDate}.
     */
    public boolean containsPlan(PlannedDate plannedDate) {
        return plannedDates.hasPlannedDate(plannedDate);
    }

    /**
     * Adds {@code plannedDate} into the planned recipes and recipe map.
     * The planned recipe must not exist in the planned book.
     */
    public void addOnePlan(Recipe recipe, PlannedDate plannedDate) {
        plannedDates.add(plannedDate);
        recipeMap.addOnePlannedRecipe(recipe, plannedDate);
    }

    /**
     * Updates the recipe map for all {@code recipes}.
     * Adds {@code plannedDate} into the planned recipes list.
     * The planned recipe must not exist in the planned book.
     */
    public void addAllRecipesToPlan(List<Recipe> recipes, PlannedDate plannedDate) {
        plannedDates.add(plannedDate);
        recipeMap.addAllRecipesToPlan(recipes, plannedDate);
    }

    /**
     * Deletes {@code recipe} from all planned dates in the planned recipes list and map.
     */
    public void deleteAllRecipePlans(Recipe recipe) {
        List<PlannedDate> plans = new ArrayList<>(recipeMap.getPlans(recipe));
        recipeMap.deleteAllPlannedRecipes(recipe);
        for (PlannedDate plan: plans) {
            if (plan.isOneRecipe()) {
                plannedDates.remove(plan); // delete planned date if it consisted of that one recipe only
            } else {
                plannedDates.remove(plan);
                PlannedDate newPlannedDate = plan.deleteRecipe(recipe);
                plannedDates.add(newPlannedDate);
            }
        }
    }

    /**
     * Deletes {@code recipe} from the planned recipes internal list in the {@code plannedDate}.
     * If the {@code recipe} is the last recipe in the internal list, delete the {@code plannedDate}
     * from the plannedRecipes list.
     * Deletes {@code recipe} in the mapping as well.
     */
    public void deleteOnePlan(Recipe recipe, PlannedDate plannedDate) {
        if (plannedDate.isOneRecipe()) { // if one recipe is left, remove plannedDate
            plannedDates.remove(plannedDate);
        } else {
            PlannedDate updatedPlan = plannedDate.deleteRecipe(recipe);
            plannedDates.setPlannedDate(plannedDate, updatedPlan);
        }
        recipeMap.deleteOnePlannedRecipe(recipe, plannedDate);
    }

    /**
     * Sets {@code target} to {@code editedRecipe} in the list and map.
     */
    public void setRecipe(Recipe target, Recipe editedRecipe) {
        if (recipeMap.contains(target)) {
            List<PlannedDate> oldPlans = new ArrayList<>(recipeMap.getPlans(target));
            List<PlannedDate> newPlans = new ArrayList<>();
            for (PlannedDate plan : oldPlans) {
                plannedDates.remove(plan);
                PlannedDate newPlan = plan.setRecipe(target, editedRecipe);
                newPlans.add(newPlan);
                plannedDates.add(newPlan);
            }
            recipeMap.setRecipe(target, editedRecipe, newPlans);
        }
    }

    /**
     * Returns the list of plans that uses {@code recipe}.
     * Returns an empty list of there are no recipes.
     */
    public List<PlannedDate> getPlans(Recipe recipe) {
        return recipeMap.getPlans(recipe);
    }

/*    *//**
     * Marks the {@code recipeCooked} in {@code plannedDate} as completed.
     * Removes {@code recipeCooked} from the mapping as well.
     *//*
    public void completePlan(Recipe recipeCooked, PlannedDate plannedDate) {
        plannedDates.complete(recipeCooked, plannedDate);
        recipeMap.deleteOnePlannedRecipe(recipeCooked, plannedDate);
    }*/

    private void removeMapping(Recipe recipe, PlannedDate plannedDate) {
        // todo
    }

    // ===== Util methods =====

    @Override
    public ObservableList<PlannedDate> getPlannedList() {
        return plannedDates.asUnmodifiableObservableList();
    }

    @Override
    public PlannedRecipeMap getPlannedMap() {
        return recipeMap;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PlannedBook // instanceof handles nulls
                && plannedDates.equals(((PlannedBook) other).plannedDates));
    }

    @Override
    public int hashCode() {
        return plannedDates.hashCode();
    }

}
