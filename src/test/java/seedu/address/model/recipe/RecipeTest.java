package seedu.address.model.recipe;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static seedu.address.logic.commands.CommandTestUtil.VALID_GOAL_PROTEIN;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_FISH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_STEP_FISH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TIME_FISH;

import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalRecipes.VEGAN_THAI_GREEN_CURRY_SOUP;
import static seedu.address.testutil.TypicalRecipes.FISH;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.RecipeBuilder;

public class RecipeTest {

    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        Recipe recipe = new RecipeBuilder().build();
        assertThrows(UnsupportedOperationException.class, () -> recipe.getGoals().remove(0));
    }

    @Test
    public void isSameRecipe() {
        // same object -> returns true
        assertTrue(VEGAN_THAI_GREEN_CURRY_SOUP.isSameRecipe(VEGAN_THAI_GREEN_CURRY_SOUP));

        // null -> returns false
        assertFalse(VEGAN_THAI_GREEN_CURRY_SOUP.isSameRecipe(null));

        // different time and email -> returns false
        Recipe editedCaesar = new RecipeBuilder(VEGAN_THAI_GREEN_CURRY_SOUP)
                .withTime(VALID_TIME_FISH).withSteps(VALID_STEP_FISH).build();
        assertFalse(VEGAN_THAI_GREEN_CURRY_SOUP.isSameRecipe(editedCaesar));

        // different name -> returns false
        editedCaesar = new RecipeBuilder(VEGAN_THAI_GREEN_CURRY_SOUP).withName(VALID_NAME_FISH).build();
        assertFalse(VEGAN_THAI_GREEN_CURRY_SOUP.isSameRecipe(editedCaesar));

        // same name, same time, different attributes -> returns true
        editedCaesar = new RecipeBuilder(VEGAN_THAI_GREEN_CURRY_SOUP).withSteps(VALID_STEP_FISH)
                .withGoals(VALID_GOAL_PROTEIN).build();
        assertTrue(VEGAN_THAI_GREEN_CURRY_SOUP.isSameRecipe(editedCaesar));

        // same name, same email, different attributes -> returns true
        editedCaesar = new RecipeBuilder(VEGAN_THAI_GREEN_CURRY_SOUP).withTime(VALID_TIME_FISH).withGoals(VALID_GOAL_PROTEIN).build();
        assertTrue(VEGAN_THAI_GREEN_CURRY_SOUP.isSameRecipe(editedCaesar));

        // same name, same time, same email, different attributes -> returns true
        editedCaesar = new RecipeBuilder(VEGAN_THAI_GREEN_CURRY_SOUP).withGoals(VALID_GOAL_PROTEIN).build();
        assertTrue(VEGAN_THAI_GREEN_CURRY_SOUP.isSameRecipe(editedCaesar));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Recipe aliceCopy = new RecipeBuilder(VEGAN_THAI_GREEN_CURRY_SOUP).build();
        assertTrue(VEGAN_THAI_GREEN_CURRY_SOUP.equals(aliceCopy));

        // same object -> returns true
        assertTrue(VEGAN_THAI_GREEN_CURRY_SOUP.equals(VEGAN_THAI_GREEN_CURRY_SOUP));

        // null -> returns false
        assertFalse(VEGAN_THAI_GREEN_CURRY_SOUP.equals(null));

        // different type -> returns false
        assertFalse(VEGAN_THAI_GREEN_CURRY_SOUP.equals(5));

        // different recipe -> returns false
        assertFalse(VEGAN_THAI_GREEN_CURRY_SOUP.equals(FISH));

        // different name -> returns false
        Recipe editedCaesar = new RecipeBuilder(VEGAN_THAI_GREEN_CURRY_SOUP).withName(VALID_NAME_FISH).build();
        assertFalse(VEGAN_THAI_GREEN_CURRY_SOUP.equals(editedCaesar));


        // different email -> returns false
        editedCaesar = new RecipeBuilder(VEGAN_THAI_GREEN_CURRY_SOUP).withSteps(VALID_STEP_FISH).build();
        assertFalse(VEGAN_THAI_GREEN_CURRY_SOUP.equals(editedCaesar));

        // different goals -> returns false
        editedCaesar = new RecipeBuilder(VEGAN_THAI_GREEN_CURRY_SOUP).withGoals(VALID_GOAL_PROTEIN).build();
        assertFalse(VEGAN_THAI_GREEN_CURRY_SOUP.equals(editedCaesar));
    }
}
