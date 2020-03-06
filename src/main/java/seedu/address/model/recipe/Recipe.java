package seedu.address.model.recipe;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.goal.Goal;

/**
 * Represents a Recipe in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Recipe {

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;

    // Data fields
    private final Set<Goal> goals = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Recipe(Name name, Phone phone, Email email, Set<Goal> goals) {
        requireAllNonNull(name, phone, email, goals);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.goals.addAll(goals);
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    /**
     * Returns an immutable goal set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Goal> getGoals() {
        return Collections.unmodifiableSet(goals);
    }

    /**
     * Returns true if both recipes of the same name have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two recipes.
     */
    public boolean isSameRecipe(Recipe otherRecipe) {
        if (otherRecipe == this) {
            return true;
        }

        return otherRecipe != null
                && otherRecipe.getName().equals(getName())
                && (otherRecipe.getPhone().equals(getPhone()) || otherRecipe.getEmail().equals(getEmail()));
    }

    /**
     * Returns true if both recipes have the same identity and data fields.
     * This defines a stronger notion of equality between two recipes.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Recipe)) {
            return false;
        }

        Recipe otherRecipe = (Recipe) other;
        return otherRecipe.getName().equals(getName())
                && otherRecipe.getPhone().equals(getPhone())
                && otherRecipe.getEmail().equals(getEmail())
                && otherRecipe.getGoals().equals(getGoals());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, goals);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Phone: ")
                .append(getPhone())
                .append(" Email: ")
                .append(getEmail())
                .append(" Goals: ");
        getGoals().forEach(builder::append);
        return builder.toString();
    }

}
