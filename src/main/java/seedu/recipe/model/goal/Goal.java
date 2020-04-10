package seedu.recipe.model.goal;

import static java.util.Objects.requireNonNull;
import static seedu.recipe.commons.util.AppUtil.checkArgument;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.recipe.model.recipe.ingredient.MainIngredientType;

/**
 * Represents a Goal in the recipe book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidGoalName(String)}
 */
public class Goal {

    public static final String MESSAGE_CONSTRAINTS = "Goals names should contain only alphabetical letters or spaces";
    public static final List<String> VALIDGOALS = new ArrayList<>(Arrays.asList("Herbivore", "Bulk like the Hulk",
            "Wholesome Wholemeal", "Fruity Fiesta"));

    public final String goalName;
    private final MainIngredientType mainIngredientType;

    /**
     * Constructs a {@code Goal} based on main ingredient type that hits the basic nutrition requirement.
     *
     */
    public Goal(String goalName) {
        requireNonNull(goalName);
        checkArgument(isValidGoalName(goalName), MESSAGE_CONSTRAINTS);
        this.goalName = goalName;
        this.mainIngredientType = setMainIngredientType();
    }

    public Goal(MainIngredientType mainIngredientType) {
        this.mainIngredientType = mainIngredientType;
        this.goalName = setGoalName();

    }

    /**
     * Returns true if a given string is a valid goal name with the same capitalisation.
     */
    public static boolean isValidGoalName(String test) {
        for (String name : VALIDGOALS) {
            if (name.equals(test)) {
                return true;
            }
        }
        return false;
    }

    public String setGoalName() {
        String name;
        switch (mainIngredientType) {
        case VEGETABLE:
            name = "Herbivore";
            break;
        case PROTEIN:
            name = "Bulk like the Hulk";
            break;
        case GRAIN:
            name = "Wholesome Wholemeal";
            break;
        case FRUIT:
            name = "Fruity Fiesta";
            break;
        default:
            name = null;
            break;
        }
        return name;
    }

    public MainIngredientType setMainIngredientType() {
        MainIngredientType main;
        switch (this.goalName) {
        case "Herbivore":
            main = MainIngredientType.VEGETABLE;
            break;
        case "Bulk like the Hulk":
            main = MainIngredientType.PROTEIN;
            break;
        case "Wholesome Wholemeal":
            main = MainIngredientType.GRAIN;
            break;
        case "Fruity Fiesta":
            main = MainIngredientType.FRUIT;
            break;
        default:
            throw new IllegalStateException("Unexpected value: " + goalName);
        }
        return main;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Goal // instanceof handles nulls
                && goalName.toLowerCase().equals(((Goal) other).goalName.toLowerCase())); // state check
    }

    @Override
    public int hashCode() {
        return goalName.toLowerCase().hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + goalName + ']';
    }

}
