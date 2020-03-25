package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.commands.EditCommand.createEditedRecipe;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INGREDIENT_FRUIT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INGREDIENT_GRAIN;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INGREDIENT_OTHER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INGREDIENT_PROTEIN;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INGREDIENT_VEGE;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_RECIPES;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.recipe.Recipe;
import seedu.address.model.recipe.ingredient.Fruit;
import seedu.address.model.recipe.ingredient.Grain;
import seedu.address.model.recipe.ingredient.Other;
import seedu.address.model.recipe.ingredient.Protein;
import seedu.address.model.recipe.ingredient.Vegetable;

/**
 * Adds ingredient(s) to an existing recipe in the recipe book.
 */
public class AddIngredientCommand extends Command {

    public static final String COMMAND_WORD = "addIngredient";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds ingredient(s) to an existing recipe in the "
            + "recipe book.\n"
            + "Parameters: [INDEX of recipe] "
            + "[" + PREFIX_INGREDIENT_GRAIN + "GRAIN]... "
            + "[" + PREFIX_INGREDIENT_VEGE + "VEGETABLE]... "
            + "[" + PREFIX_INGREDIENT_PROTEIN + "PROTEIN]... "
            + "[" + PREFIX_INGREDIENT_FRUIT + "FRUIT]... "
            + "[" + PREFIX_INGREDIENT_OTHER + "OTHER]...\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_INGREDIENT_VEGE + "100g, Tomato "
            + PREFIX_INGREDIENT_VEGE + "100g, Lettuce "
            + PREFIX_INGREDIENT_OTHER + "50g, Honeydew";

    public static final String MESSAGE_ADD_INGREDIENTS_SUCCESS = "Successfully added ingredient(s) to %1$s!";

    private final Index index;
    private final EditCommand.EditRecipeDescriptor editRecipeDescriptor;

    /**
     * @param index of the recipe in the filtered recipe list to edit
     * @param editRecipeDescriptor details to edit the recipe with
     */
    public AddIngredientCommand(Index index, EditCommand.EditRecipeDescriptor editRecipeDescriptor) {
        this.index = index;
        this.editRecipeDescriptor = editRecipeDescriptor;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Recipe> lastShownList = model.getFilteredRecipeList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_RECIPE_DISPLAYED_INDEX);
        }

        Recipe recipeToEdit = lastShownList.get(index.getZeroBased());

        updateGrainsList(recipeToEdit, editRecipeDescriptor);
        updateVegetablesList(recipeToEdit, editRecipeDescriptor);
        updateProteinsList(recipeToEdit, editRecipeDescriptor);
        updateFruitsList(recipeToEdit, editRecipeDescriptor);
        updateOthersList(recipeToEdit, editRecipeDescriptor);

        Recipe editedRecipe = createEditedRecipe(recipeToEdit, editRecipeDescriptor);
        model.setRecipe(recipeToEdit, editedRecipe);
        model.updateFilteredRecipeList(PREDICATE_SHOW_ALL_RECIPES);
        model.commitRecipeBook();

        return new CommandResult(String.format(MESSAGE_ADD_INGREDIENTS_SUCCESS, recipeToEdit.getName().toString()));
    }

    /**
     * Adds the original list of {@code Grain} ingredients to the {@code editRecipeDescriptor}.
     */
    public void updateGrainsList(Recipe recipeToEdit, EditCommand.EditRecipeDescriptor editRecipeDescriptor) {
        if (editRecipeDescriptor.getGrains().isPresent()) {
            Set<Grain> updatedGrainsList = new TreeSet<>(editRecipeDescriptor.getGrains().get());
            updatedGrainsList.addAll(recipeToEdit.getGrains());
            editRecipeDescriptor.setGrains(updatedGrainsList);
        } else {
            editRecipeDescriptor.setGrains(recipeToEdit.getGrains());
        }
    }

    /**
     * Adds the original list of {@code Vegetable} ingredients to the {@code editRecipeDescriptor}.
     */
    public void updateVegetablesList(Recipe recipeToEdit, EditCommand.EditRecipeDescriptor editRecipeDescriptor) {
        if (editRecipeDescriptor.getVegetables().isPresent()) {
            Set<Vegetable> updatedVegetablesList = new TreeSet<>(editRecipeDescriptor.getVegetables().get());
            updatedVegetablesList.addAll(recipeToEdit.getVegetables());
            editRecipeDescriptor.setVegetables(updatedVegetablesList);
        } else {
            editRecipeDescriptor.setVegetables(recipeToEdit.getVegetables());
        }
    }

    /**
     * Adds the original list of {@code Protein} ingredients to the {@code editRecipeDescriptor}.
     */
    public void updateProteinsList(Recipe recipeToEdit, EditCommand.EditRecipeDescriptor editRecipeDescriptor) {
        if (editRecipeDescriptor.getProteins().isPresent()) {
            Set<Protein> updatedProteinsList = new TreeSet<>(editRecipeDescriptor.getProteins().get());
            updatedProteinsList.addAll(recipeToEdit.getProteins());
            editRecipeDescriptor.setProteins(updatedProteinsList);
        } else {
            editRecipeDescriptor.setProteins(recipeToEdit.getProteins());
        }
    }

    /**
     * Adds the original list of {@code Fruit} ingredients to the {@code editRecipeDescriptor}.
     */
    public void updateFruitsList(Recipe recipeToEdit, EditCommand.EditRecipeDescriptor editRecipeDescriptor) {
        if (editRecipeDescriptor.getFruits().isPresent()) {
            Set<Fruit> updatedFruitsList = new TreeSet<>(editRecipeDescriptor.getFruits().get());
            updatedFruitsList.addAll(recipeToEdit.getFruits());
            editRecipeDescriptor.setFruits(updatedFruitsList);
        } else {
            editRecipeDescriptor.setFruits(recipeToEdit.getFruits());
        }
    }

    /**
     * Adds the original list of {@code Other} ingredients to the {@code editRecipeDescriptor}.
     */
    public void updateOthersList(Recipe recipeToEdit, EditCommand.EditRecipeDescriptor editRecipeDescriptor) {
        if (editRecipeDescriptor.getOthers().isPresent()) {
            Set<Other> updatedOthersList = new TreeSet<>(editRecipeDescriptor.getOthers().get());
            updatedOthersList.addAll(recipeToEdit.getOthers());
            editRecipeDescriptor.setOthers(updatedOthersList);
        } else {
            editRecipeDescriptor.setOthers(recipeToEdit.getOthers());
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddIngredientCommand // instanceof handles nulls
                && index.equals(((AddIngredientCommand) other).index)
                && editRecipeDescriptor.equals(((AddIngredientCommand) other).editRecipeDescriptor)); // state check
    }
}
