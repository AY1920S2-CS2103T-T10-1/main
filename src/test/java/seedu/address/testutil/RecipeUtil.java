package seedu.address.testutil;

import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GOAL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;

import java.util.Set;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.EditCommand.EditRecipeDescriptor;
import seedu.address.model.goal.Goal;
import seedu.address.model.recipe.Recipe;

/**
 * A utility class for Recipe.
 */
public class RecipeUtil {

    /**
     * Returns an add command string for adding the {@code recipe}.
     */
    public static String getAddCommand(Recipe recipe) {
        return AddCommand.COMMAND_WORD + " " + getRecipeDetails(recipe);
    }

    /**
     * Returns the part of command string for the given {@code recipe}'s details.
     */
    public static String getRecipeDetails(Recipe recipe) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_NAME + recipe.getName().fullName + " ");
        sb.append(PREFIX_PHONE + recipe.getPhone().value + " ");
        sb.append(PREFIX_EMAIL + recipe.getEmail().value + " ");
        recipe.getGoals().stream().forEach(
            s -> sb.append(PREFIX_GOAL + s.goalName + " ")
        );
        return sb.toString();
    }

    /**
     * Returns the part of command string for the given {@code EditRecipeDescriptor}'s details.
     */
    public static String getEditRecipeDescriptorDetails(EditRecipeDescriptor descriptor) {
        StringBuilder sb = new StringBuilder();
        descriptor.getName().ifPresent(name -> sb.append(PREFIX_NAME).append(name.fullName).append(" "));
        descriptor.getPhone().ifPresent(phone -> sb.append(PREFIX_PHONE).append(phone.value).append(" "));
        descriptor.getEmail().ifPresent(email -> sb.append(PREFIX_EMAIL).append(email.value).append(" "));
        if (descriptor.getGoals().isPresent()) {
            Set<Goal> goals = descriptor.getGoals().get();
            if (goals.isEmpty()) {
                sb.append(PREFIX_GOAL);
            } else {
                goals.forEach(s -> sb.append(PREFIX_GOAL).append(s.goalName).append(" "));
            }
        }
        return sb.toString();
    }
}
