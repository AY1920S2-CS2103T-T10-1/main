package seedu.recipe.model.cooked;

import static java.util.Objects.requireNonNull;
import static seedu.recipe.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.recipe.model.goal.Goal;
import seedu.recipe.model.recipe.Recipe;
import seedu.recipe.model.recipe.exceptions.DuplicateRecipeException;
import seedu.recipe.model.recipe.exceptions.RecipeNotFoundException;

/**
 * A list of records that enforces uniqueness between its elements and does not allow nulls.
 * A record is considered unique by comparing using {@code Record#isSameRecord(Record)}. As such, adding and updating of
 * records uses Record#isSameRecord(Record) for equality so as to ensure that the recipe being added or updated is
 * unique in terms of identity in the UniqueRecipeList. However, the removal of a record uses Record#equals(Object) so
 * as to ensure that the record with exactly the same fields will be removed.
 *
 * Supports a minimal set of list operations.
 *
 * @see Recipe#isSameRecipe(Recipe)
 */
public class UniqueRecordList implements Iterable<Record> {

    private final ObservableList<Record> internalList = FXCollections.observableArrayList();
    private final ObservableList<Record> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    private final ObservableList<Integer> internalGoalsList = FXCollections.observableArrayList();
    private final ObservableList<Integer> internalUnmodifiableGoalsList =
            FXCollections.unmodifiableObservableList(internalGoalsList);


    public void setRecords(UniqueRecordList replacement) {
        requireNonNull(replacement);
        internalList.setAll(replacement.internalList);
    }

    /**
     * Replaces the contents of this list with {@code recipes}.
     * {@code recipes} must not contain duplicate recipes.
     */
    public void setRecords(List<Record> records) {
        requireAllNonNull(records);
        if (!recordsAreUnique(records)) {
            throw new DuplicateRecipeException();
        }

        internalList.setAll(records);
        setGoalsTally();
    }

    /**
     * Returns true if the list contains an equivalent record as the given argument.
     */
    public boolean contains(Record toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameRecord);
    }

    /**
     * Adds a record to the list.
     * The record must not already exist in the list.
     */
    public void add(Record toAdd) {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            throw new DuplicateRecipeException();
        }
        internalList.add(toAdd);
    }

    /**
     * Replaces the record {@code target} in the list with {@code editedRecord}.
     * {@code target} must exist in the list.
     * The recipe identity of {@code editedRecord} must not be the same as another existing record in the list.
     */
    public void setRecord(Record target, Record editedRecord) {
        requireAllNonNull(target, editedRecord);

        int index = internalList.indexOf(target);
        if (index == -1) {
            //exception to be changed
            throw new RecipeNotFoundException();
        }

        if (!target.isSameRecord(editedRecord) && contains(editedRecord)) {
            throw new DuplicateRecipeException();
        }

        internalList.set(index, editedRecord);
    }

    /**
     * Removes the equivalent record from the list.
     * The record must exist in the list.
     */
    public void remove(Record toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            throw new RecipeNotFoundException();
        }
    }

    public ObservableList<Record> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<Record> iterator() {
        return internalList.iterator();
    }

    /**
     * Returns true if {@code recipes} contains only unique recipes.
     */
    private boolean recordsAreUnique(List<Record> records) {
        for (int i = 0; i < records.size() - 1; i++) {
            for (int j = i + 1; j < records.size(); j++) {
                if (records.get(i).isSameRecord(records.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Sets goal tally when records are set initially.
     */
    private void setGoalsTally() {
        HashMap<String, Integer> goalMap = new HashMap<String, Integer>();
        goalMap.put("Herbivore", 0);
        goalMap.put("Fruity Fiesta", 0);
        goalMap.put("Bulk like the Hulk", 0);
        goalMap.put("Wholesome Wholemeal", 0);

        for (int i = 0; i < internalList.size(); i++) {

            List<Goal> currGoals = new ArrayList<Goal>();
            currGoals.addAll(internalList.get(i).getGoals());
            for (Goal currGoal : currGoals) {
                String goalName = currGoal.goalName;
                if (goalMap.containsKey(goalName)) {
                    Integer prevCount = goalMap.get(goalName);
                    goalMap.put(goalName, prevCount + 1);
                }
            }
        }
        internalGoalsList.addAll(
                goalMap.get("Herbivore"),
                goalMap.get("Fruity Fiesta"),
                goalMap.get("Bulk like the Hulk"),
                goalMap.get("Wholesome Wholemeal"));
    }

    /**
     * Updates goals for a record where index.
     * 0: Herbivores 1: Fruity Fiesta.
     * 2: Bulk Like the Hulk. 3:Wholesome Wholemeal.
     * @param record
     */
    public void updateGoalsTally(Record record) {
        List<Goal> currGoals = new ArrayList<Goal>();
        currGoals.addAll(record.getGoals());
        for (Goal currGoal: currGoals) {
            String goalName = currGoal.goalName;
            int currCount = 0;
            switch(goalName) {

            case "Herbivore":
                currCount = internalGoalsList.get(0);
                internalGoalsList.set(0, currCount + 1);
                break;
            case "Fruity Fiesta":
                currCount = internalGoalsList.get(1);
                internalGoalsList.set(1, currCount + 1);
                break;
            case "Bulk like the Hulk":
                currCount = internalGoalsList.get(2);
                internalGoalsList.set(2, currCount + 1);
                break;
            case "Wholesome Wholemeal":
                currCount = internalGoalsList.get(3);
                internalGoalsList.set(3, currCount + 1);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + goalName);
            }
        }
    }

    /**
     * Returns goalTally for all main {@code goal} in cookedRecordBook.
     */
    public ObservableList<Integer> getGoalsTally() {
        return internalUnmodifiableGoalsList;
    }
}
