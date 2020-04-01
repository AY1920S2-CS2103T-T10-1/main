package seedu.recipe.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.recipe.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.recipe.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.recipe.logic.commands.CommandTestUtil.showRecipeAtIndex;
import static seedu.recipe.testutil.TypicalIndexes.INDEX_FIRST_RECIPE;
import static seedu.recipe.testutil.TypicalIndexes.INDEX_SECOND_RECIPE;
import static seedu.recipe.testutil.TypicalRecipes.getTypicalRecipeBook;

import org.junit.jupiter.api.Test;

import seedu.recipe.commons.core.Messages;
import seedu.recipe.commons.core.index.Index;
import seedu.recipe.model.Model;
import seedu.recipe.model.ModelManager;
import seedu.recipe.model.UserPrefs;
import seedu.recipe.model.plan.PlannedBook;
import seedu.recipe.model.recipe.Recipe;
import seedu.recipe.testutil.RecipeBuilder;

/**
 * Contains integration tests (interaction with the Model, UndoCommand and RedoCommand) and unit tests for
 * {@code DeleteStepCommandTest}.
 */
public class DeleteStepCommandTest {

    private Model model = new ModelManager(getTypicalRecipeBook(), new PlannedBook(), new UserPrefs());
    private final Integer[] INDEX_SECOND_STEP = new Integer[] {1}; // Index of steps is zero-based (implemented as such)
    private final Integer[] INDEX_OUT_OF_BOUNDS_STEP = new Integer[] {Integer.MAX_VALUE};

    @Test
    public void execute_validRecipeAndStepIndexUnfilteredList_success() {
        Recipe recipeToDeleteSteps = model.getFilteredRecipeList().get(INDEX_SECOND_RECIPE.getZeroBased());
        DeleteStepCommand deleteStepCommand = new DeleteStepCommand(INDEX_SECOND_RECIPE, INDEX_SECOND_STEP);

        String expectedMessageTemplate = "Successfully deleted step(s) from %1$s!";
        String expectedMessage = String.format(expectedMessageTemplate, recipeToDeleteSteps.getName().toString());

        ModelManager expectedModel = new ModelManager(model.getRecipeBook(), new PlannedBook(), new UserPrefs());
        Recipe expectedRecipe = new RecipeBuilder().withName("Grilled Sandwich")
                .withTime("10")
                .withGrains("50g, Bread")
                .withOthers("50g, Cheese")
                .withSteps("Spread butter on bread")
                .withGoals("Wholesome Wholemeal").build();
        expectedModel.setRecipe(recipeToDeleteSteps, expectedRecipe);

        assertCommandSuccess(deleteStepCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredRecipeList().size() + 1);
        DeleteStepCommand deleteStepCommand = new DeleteStepCommand(outOfBoundIndex, INDEX_SECOND_STEP);

        assertCommandFailure(deleteStepCommand, model, Messages.MESSAGE_INVALID_RECIPE_DISPLAYED_INDEX);
    }

    @Test
    public void execute_invalidStepIndexUnfilteredList_throwsCommandException() {
        DeleteStepCommand deleteStepCommand = new DeleteStepCommand(INDEX_FIRST_RECIPE, INDEX_OUT_OF_BOUNDS_STEP);

        assertCommandFailure(deleteStepCommand, model, DeleteStepCommand.MESSAGE_INVALID_STEP_INDEX);
    }

    @Test
    public void execute_invalidIndexAndStepIndexUnfilteredList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredRecipeList().size() + 1);
        DeleteStepCommand deleteStepCommand = new DeleteStepCommand(outOfBoundIndex, INDEX_OUT_OF_BOUNDS_STEP);

        // The error for RECIPE index out of bounds should be thrown first even though STEP index is also out of bounds
        assertCommandFailure(deleteStepCommand, model, Messages.MESSAGE_INVALID_RECIPE_DISPLAYED_INDEX);
    }

    @Test
    public void execute_validRecipeAndStepIndexFilteredList_success() {
        showRecipeAtIndex(model, INDEX_SECOND_RECIPE);

        Recipe recipeToDeleteSteps = model.getFilteredRecipeList().get(INDEX_FIRST_RECIPE.getZeroBased());
        DeleteStepCommand deleteStepCommand = new DeleteStepCommand(INDEX_FIRST_RECIPE, INDEX_SECOND_STEP);

        String expectedMessageTemplate = "Successfully deleted step(s) from %1$s!";
        String expectedMessage = String.format(expectedMessageTemplate, recipeToDeleteSteps.getName().toString());

        Model expectedModel = new ModelManager(model.getRecipeBook(), new PlannedBook(), new UserPrefs());
        Recipe expectedRecipe = new RecipeBuilder().withName("Grilled Sandwich")
                .withTime("10")
                .withGrains("50g, Bread")
                .withOthers("50g, Cheese")
                .withSteps("Spread butter on bread")
                .withGoals("Wholesome Wholemeal").build();
        expectedModel.setRecipe(recipeToDeleteSteps, expectedRecipe);

        assertCommandSuccess(deleteStepCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexFilteredList_throwsCommandException() {
        showRecipeAtIndex(model, INDEX_FIRST_RECIPE);

        Index outOfBoundIndex = INDEX_SECOND_RECIPE;
        // Ensures that outOfBoundIndex is still in bounds of recipe book list
        assertTrue(outOfBoundIndex.getZeroBased() < model.getRecipeBook().getRecipeList().size());

        DeleteStepCommand deleteStepCommand = new DeleteStepCommand(outOfBoundIndex, INDEX_SECOND_STEP);

        assertCommandFailure(deleteStepCommand, model, Messages.MESSAGE_INVALID_RECIPE_DISPLAYED_INDEX);
    }

    @Test
    public void execute_invalidStepIndexFilteredList_throwsCommandException() {
        showRecipeAtIndex(model, INDEX_FIRST_RECIPE);

        DeleteStepCommand deleteStepCommand = new DeleteStepCommand(INDEX_FIRST_RECIPE, INDEX_OUT_OF_BOUNDS_STEP);

        assertCommandFailure(deleteStepCommand, model, DeleteStepCommand.MESSAGE_INVALID_STEP_INDEX);
    }

    @Test
    public void execute_invalidIndexAndStepIndexFilteredList_throwsCommandException() {
        showRecipeAtIndex(model, INDEX_FIRST_RECIPE);

        Index outOfBoundIndex = INDEX_SECOND_RECIPE;
        // Ensures that outOfBoundIndex is still in bounds of recipe book list
        assertTrue(outOfBoundIndex.getZeroBased() < model.getRecipeBook().getRecipeList().size());

        DeleteStepCommand deleteStepCommand = new DeleteStepCommand(outOfBoundIndex, INDEX_OUT_OF_BOUNDS_STEP);

        // The error for RECIPE index out of bounds should be thrown first even though STEP index is also out of bounds
        assertCommandFailure(deleteStepCommand, model, Messages.MESSAGE_INVALID_RECIPE_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        DeleteStepCommand deleteStepFirstCommand = new DeleteStepCommand(INDEX_FIRST_RECIPE, INDEX_SECOND_STEP);
        DeleteStepCommand deleteStepSecondCommand = new DeleteStepCommand(INDEX_SECOND_RECIPE, INDEX_SECOND_STEP);

        // same object -> returns true
        assertTrue(deleteStepFirstCommand.equals(deleteStepFirstCommand));

        // same values -> returns true
        DeleteStepCommand deleteStepFirstCommandCopy = new DeleteStepCommand(INDEX_FIRST_RECIPE, INDEX_SECOND_STEP);
        assertTrue(deleteStepFirstCommand.equals(deleteStepFirstCommandCopy));

        // different types -> returns false
        assertFalse(deleteStepFirstCommand.equals(1));

        // null -> returns false
        assertFalse(deleteStepFirstCommand.equals(null));

        // different recipe -> returns false
        assertFalse(deleteStepFirstCommand.equals(deleteStepSecondCommand));
    }
}
