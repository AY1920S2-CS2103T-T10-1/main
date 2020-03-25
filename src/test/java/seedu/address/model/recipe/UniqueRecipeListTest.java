package seedu.address.model.recipe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GOAL_PROTEIN;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalRecipes.VEGAN_THAI_GREEN_CURRY_SOUP;
import static seedu.address.testutil.TypicalRecipes.FISH;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.model.recipe.exceptions.DuplicateRecipeException;
import seedu.address.model.recipe.exceptions.RecipeNotFoundException;
import seedu.address.testutil.RecipeBuilder;

public class UniqueRecipeListTest {

    private final UniqueRecipeList uniqueRecipeList = new UniqueRecipeList();

    @Test
    public void contains_nullRecipe_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueRecipeList.contains(null));
    }

    @Test
    public void contains_recipeNotInList_returnsFalse() {
        assertFalse(uniqueRecipeList.contains(VEGAN_THAI_GREEN_CURRY_SOUP));
    }

    @Test
    public void contains_recipeInList_returnsTrue() {
        uniqueRecipeList.add(VEGAN_THAI_GREEN_CURRY_SOUP);
        assertTrue(uniqueRecipeList.contains(VEGAN_THAI_GREEN_CURRY_SOUP));
    }

    @Test
    public void contains_recipeWithSameIdentityFieldsInList_returnsTrue() {
        uniqueRecipeList.add(VEGAN_THAI_GREEN_CURRY_SOUP);
        Recipe editedAlice = new RecipeBuilder(VEGAN_THAI_GREEN_CURRY_SOUP).withGoals(VALID_GOAL_PROTEIN)
                .build();
        assertTrue(uniqueRecipeList.contains(editedAlice));
    }

    @Test
    public void add_nullRecipe_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueRecipeList.add(null));
    }

    @Test
    public void add_duplicateRecipe_throwsDuplicateRecipeException() {
        uniqueRecipeList.add(VEGAN_THAI_GREEN_CURRY_SOUP);
        assertThrows(DuplicateRecipeException.class, () -> uniqueRecipeList.add(VEGAN_THAI_GREEN_CURRY_SOUP));
    }

    @Test
    public void setRecipe_nullTargetRecipe_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueRecipeList.setRecipe(null, VEGAN_THAI_GREEN_CURRY_SOUP));
    }

    @Test
    public void setRecipe_nullEditedRecipe_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueRecipeList.setRecipe(VEGAN_THAI_GREEN_CURRY_SOUP, null));
    }

    @Test
    public void setRecipe_targetRecipeNotInList_throwsRecipeNotFoundException() {
        assertThrows(RecipeNotFoundException.class, () -> uniqueRecipeList.setRecipe(VEGAN_THAI_GREEN_CURRY_SOUP, VEGAN_THAI_GREEN_CURRY_SOUP));
    }

    @Test
    public void setRecipe_editedRecipeIsSameRecipe_success() {
        uniqueRecipeList.add(VEGAN_THAI_GREEN_CURRY_SOUP);
        uniqueRecipeList.setRecipe(VEGAN_THAI_GREEN_CURRY_SOUP, VEGAN_THAI_GREEN_CURRY_SOUP);
        UniqueRecipeList expectedUniqueRecipeList = new UniqueRecipeList();
        expectedUniqueRecipeList.add(VEGAN_THAI_GREEN_CURRY_SOUP);
        assertEquals(expectedUniqueRecipeList, uniqueRecipeList);
    }

    @Test
    public void setRecipe_editedRecipeHasSameIdentity_success() {
        uniqueRecipeList.add(VEGAN_THAI_GREEN_CURRY_SOUP);
        Recipe editedAlice = new RecipeBuilder(VEGAN_THAI_GREEN_CURRY_SOUP).withGoals(VALID_GOAL_PROTEIN).build();
        uniqueRecipeList.setRecipe(VEGAN_THAI_GREEN_CURRY_SOUP, editedAlice);
        UniqueRecipeList expectedUniqueRecipeList = new UniqueRecipeList();
        expectedUniqueRecipeList.add(editedAlice);
        assertEquals(expectedUniqueRecipeList, uniqueRecipeList);
    }

    @Test
    public void setRecipe_editedRecipeHasDifferentIdentity_success() {
        uniqueRecipeList.add(VEGAN_THAI_GREEN_CURRY_SOUP);
        uniqueRecipeList.setRecipe(VEGAN_THAI_GREEN_CURRY_SOUP, FISH);
        UniqueRecipeList expectedUniqueRecipeList = new UniqueRecipeList();
        expectedUniqueRecipeList.add(FISH);
        assertEquals(expectedUniqueRecipeList, uniqueRecipeList);
    }

    @Test
    public void setRecipe_editedRecipeHasNonUniqueIdentity_throwsDuplicateRecipeException() {
        uniqueRecipeList.add(VEGAN_THAI_GREEN_CURRY_SOUP);
        uniqueRecipeList.add(FISH);
        assertThrows(DuplicateRecipeException.class, () -> uniqueRecipeList.setRecipe(VEGAN_THAI_GREEN_CURRY_SOUP, FISH));
    }

    @Test
    public void remove_nullRecipe_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueRecipeList.remove(null));
    }

    @Test
    public void remove_recipeDoesNotExist_throwsRecipeNotFoundException() {
        assertThrows(RecipeNotFoundException.class, () -> uniqueRecipeList.remove(VEGAN_THAI_GREEN_CURRY_SOUP));
    }

    @Test
    public void remove_existingRecipe_removesRecipe() {
        uniqueRecipeList.add(VEGAN_THAI_GREEN_CURRY_SOUP);
        uniqueRecipeList.remove(VEGAN_THAI_GREEN_CURRY_SOUP);
        UniqueRecipeList expectedUniqueRecipeList = new UniqueRecipeList();
        assertEquals(expectedUniqueRecipeList, uniqueRecipeList);
    }

    @Test
    public void setRecipes_nullUniqueRecipeList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueRecipeList.setRecipes((UniqueRecipeList) null));
    }

    @Test
    public void setRecipes_uniqueRecipeList_replacesOwnListWithProvidedUniqueRecipeList() {
        uniqueRecipeList.add(VEGAN_THAI_GREEN_CURRY_SOUP);
        UniqueRecipeList expectedUniqueRecipeList = new UniqueRecipeList();
        expectedUniqueRecipeList.add(FISH);
        uniqueRecipeList.setRecipes(expectedUniqueRecipeList);
        assertEquals(expectedUniqueRecipeList, uniqueRecipeList);
    }

    @Test
    public void setRecipes_nullList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueRecipeList.setRecipes((List<Recipe>) null));
    }

    @Test
    public void setRecipes_list_replacesOwnListWithProvidedList() {
        uniqueRecipeList.add(VEGAN_THAI_GREEN_CURRY_SOUP);
        List<Recipe> recipeList = Collections.singletonList(FISH);
        uniqueRecipeList.setRecipes(recipeList);
        UniqueRecipeList expectedUniqueRecipeList = new UniqueRecipeList();
        expectedUniqueRecipeList.add(FISH);
        assertEquals(expectedUniqueRecipeList, uniqueRecipeList);
    }

    @Test
    public void setRecipes_listWithDuplicateRecipes_throwsDuplicateRecipeException() {
        List<Recipe> listWithDuplicateRecipes = Arrays.asList(VEGAN_THAI_GREEN_CURRY_SOUP, VEGAN_THAI_GREEN_CURRY_SOUP);
        assertThrows(DuplicateRecipeException.class, () -> uniqueRecipeList.setRecipes(listWithDuplicateRecipes));
    }

    @Test
    public void asUnmodifiableObservableList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, ()
            -> uniqueRecipeList.asUnmodifiableObservableList().remove(0));
    }
}
