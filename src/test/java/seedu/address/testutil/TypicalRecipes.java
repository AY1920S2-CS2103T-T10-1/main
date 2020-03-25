package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_FRUIT_FISH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_FRUIT_TURKEY_SANDWICH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GOAL_GRAIN;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GOAL_PROTEIN;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GRAIN_FISH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GRAIN_TURKEY_SANDWICH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_FISH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_TURKEY_SANDWICH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_OTHER_FISH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_OTHER_TURKEY_SANDWICH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PROTEIN_FISH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PROTEIN_TURKEY_SANDWICH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_STEP_FISH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_STEP_TURKEY_SANDWICH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TIME_FISH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TIME_TURKEY_SANDWICH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_VEGE_FISH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_VEGE_TURKEY_SANDWICH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.RecipeBook;
import seedu.address.model.recipe.Recipe;

/**
 * A utility class containing a list of {@code Recipe} objects to be used in tests.
 */
public class TypicalRecipes {

    public static final Recipe VEGAN_THAI_GREEN_CURRY_SOUP = new RecipeBuilder().withName("Vegan Thai Green Curry Soup")
            .withTime("35")
            .withGrains("rice vermicelli noodles, 200g")
            .withVegetables("100g,button mushrooms sliced","1 cup, broccoli florets", "10g, Thai red eye bird's chili" )
            .withOthers(" 1 tbsp,thai Green Curry Paste",
                                "0.25 Cup, coconut milk", "2 tsp, oil",
                                "1 tsp, Salt" , "1 tsp, soy sauce",
                                "0.5 tsp, brown sugar")
            .withSteps("Heat oil in a saucepan. Add the vegetables (broccoli, mushroom) and saute till they turn soft. Transfer to a plate and set aside.",
                    "In the same saucepan, add the green curry paste. Saute the curry paste for a minute.",
                    "Add the coconut milk, brown sugar and soy sauce. Stir until the curry paste is nicely dissolved.",
                    "Now add the vegetable stock, salt, red chillies and stir to combine.",
                    "Bring the soup to a boil over high heat. Reduce the heat and allow the soup to simmer for 5 minutes.",
                    "Add the vermicelli noodles and the vegetables. Simmer till the noodles are cooked.",
                    "Turn off the heat and give soup a nice stir. Taste and adjust the seasoning and consistency accordingly. If too thick add more stock or coconut milk.",
                    "Just before serving garnish soup with fresh herbs, crushed peanuts and juice of lemon.",
                    "Serve Thai Green Curry Soup warm.")
            .withGoals("Herbivore").build();
    public static final Recipe THAI_BASIL_GROUND_BEEF_BOWL = new RecipeBuilder().withName("Thai Basil Ground Beef Bowl")
            .withTime("25")
            .withVegetables("20g, garlic cloves (minced)","20g, garlic clove", "2 cups, asparagus (chopped)", "0.25 cup, Thai basil",
                    "200g, cauliflower",
                    "0.25 cup, onion")
            .withProteins("500g, 95% lean ground beef", "1 tbsp, fresh ginger (minced)")
            .withOthers("2 tbsp, low sodium soy sauce",
                    "2 tsp, chilli paste", "1 tbsp, coconut oil (or olive oil)")
            .withSteps("Prepare the cauliflower rice. Chop the cauliflower into florets and add to a food processor with the onion and garlic. Pulse into fine rice like pieces. You may have to do this in batches depending on your food processor. To cook, saute the cauliflower rice in 1 tbsp. coconut oil over medium heat until soft. You can also microwave it for 4-5 minutes.",
                    "Add the beef to a hot nonstick skillet over medium high heat. Brown and break up the larger chunks as you go until no longer pink.",
                    "Add in the garlic, ginger, green onions, and asparagus. Cook until the asparagus is just tender, about 3-4 minutes.",
                    "Add the soy sauce, chili paste, and basil. Cook for 30 seconds and remove from heat. Taste and season as needed with additional soy or chili sauce.",
                    "Serve the Thai Basil Beef over the cauliflower rice.")
            .withGoals("Bulk like the Hulk").build();

    public static final Recipe BARLEY_PILAF = new RecipeBuilder().withName("Barley Pilaf")
            .withTime("50")
            .withGrains("½ cup, small pieces of broken spaghetti")
            .withVegetables("50g, small onion (chopped)", "2 tbsp, chives (chopped)")
            .withProteins("2.5 cups, low-sodium chicken broth")
            .withOthers("1 tbsp, unsalted butter", "1 cup, hulled barley", "10g, Salt & Pepper")
            .withSteps("Melt butter in saucepan over medium heat. Add onion and cook until soft and light golden brown.",
                    "Add barley and stir until grains are coated in butter.",
                    "Add broth and ½ tsp salt, bring to a boil.",
                    "Reduce heat to medium low, cover, and simmer for 20mins.",
                    "Uncover and quickly stir in spaghetti. Cover and continue to simmer, stirring occasionally.",
                    "Once most liquid is absorbed and barley and spaghetti are tender, remove from hit and let sit.",
                    "Season to taste with salt and pepper and sprinkle with chopped chives.")
            .withGoals("Wholesome Wholemeal").build();

    public static final Recipe ASIAN_BBQ_CHICKEN = new RecipeBuilder().withName("Asian BBQ Chicken")
            .withTime("30")
            .withVegetables("1 tbsp, garlic & ginger (finely chopped)")
            .withProteins("100g, Chicken breast")
            .withOthers("2 tbsp, char siew sauce", "1 tbsp, rice vinegar",
                    "1 tsp, honey",
                    "½ tsp, sesame oil",
                    "1 tsp, Salt & pepper")
            .withSteps("In a bowl, mix all the ingredients to create marinade. Mix the chicken with the marinade.",
                    "Pan sear the chicken from both sides.",
                    "Serve with rice.")
            .withGoals("Bulk like the Hulk").build();

    public static final Recipe SWEET_AND_SOUR_CHICKEN = new RecipeBuilder().withName("Sweet and Sour Chicken")
            .withTime("20")
            .withVegetables( "10g, Garlic cloves",
                    "10g, knob ginger", "1 cup, carrots (diced)",
                    "1 cup, chinese cabbage (diced)",
                    "1 cup, bell peppers", "1 cup, onions (diced)")
            .withProteins("300 grams, chicken")
            .withFruits("1 cup, pineapple (diced)", "1 tbsp, tomato juice")
            .withOthers("1.5 tsp, corn flour",
                    "50g, egg", "1 tsp, light soya sauce",
                    "1 tbsp, vegetable oil", "10g, Coriander (optional)" )
            .withSteps("Pound garlic and ginger into a paste. Marinade chicken in the paste, along with corn flour, soy sauce, and salt.",
                    "In a wok, take some oil, saute the carrots, cabbage, onions, and bell peppers. Add tomato juice and bring to a slight boil.",
                    "Fry the chicken and add to the wok along with some stock and set to simmer.",
                    "Garnish with coriander and serve with rice.")
            .withGoals("Bulk like the Hulk").build();

    public static final Recipe QUICK_CARROT_DAIKON_STIR_FRY = new RecipeBuilder().withName("Quick Carrot Daikon Stir-fry")
            .withTime("25")
            .withVegetables("30g, ginger (julienned)",
                    "30g, garlic (smashed and chopped)",
                    "50g, carrot (julienned)",
                    "20g, Daikon radish (peeled and julienned)", "20g, scallions" )
            .withOthers("3 tbsp, vegetable oil", "1 tbsp, shaoxing wine",
                    "1.5 tbsp, oyster sauce",
                    "¼ tsp, white pepper",
                    "½ tsp, sesame oil",
                    "½ tsp, salt",
                    "¼ cup, water")
            .withSteps("Heat oil in wok over medium heat. Add ginger and garlic and cook for 20 seconds.",
                    "Add carrot and stir-fry for 30 seconds - oil should turn orange colour. Add in daikon, turn up heat to high and stir-fry for another 30 seconds.",
                    "Add shaoxing wine, oyster sauce, white pepper, sesame oil, salt, water, and white parts of the scallions. Stir to combine, cover, turn down heat to medium. Simmer for 5-8 minutes until tender.",
                    "Uncover, add in rest of the scallions and mix everything well. When dailon is translucent and tender, the dish is done.")
            .withGoals("Herbivore").build();

    public static final Recipe CHINESE_TOMATO_EGG_STIR_FRY = new RecipeBuilder().withName("Chinese Tomato Egg Stir-fry")
            .withTime("10")
            .withVegetables("30g, tomatoes", "10g, scallion")
            .withProteins("50g, Egg")
            .withOthers("¾ tsp, salt", "¼ tsp, white pepper",
                    "½ tsp, sesame oil", "1 tsp, shaoxing wine", "3 tbsp, vegetable oil",
                    "2 tsp, sugar", "¼ cup, water")
            .withSteps("Cut tomatoes into small wedges and finely chop scallion",
                    "Crack eggs into bowl and season with ¼ tsp salt, white pepper",
                    "sesame oil, and shaoxing wine. Beat the eggs.",
                    "Preheat wok over medium heat until it starts to smoke. Add 2 tbsp of oil and immediately add eggs. Scramble the eggs and remove from wok immediately. Set aside.",
                    "Add the remaining tbsp of oil to the wok, turn up heat to high, add tomatoes and scallions. Stir-fry for 1min, then add sugar, ½ tsp salt, and water. If water cooks off too quickly, add a little more water. Add the cooked eggs.",
                    "Mix everything together, cover the wok, cook for 1-2mins until the tomatoes are completely softened.",
                    "Uncover, continue to stir-fry over high heat until sauce thickens to your liking. Serve!")
            .withGoals("Herbivore").build();

    public static final Recipe FIVE_INGREDIENT_SPELT_SPAGHETTI = new RecipeBuilder().withName("5 Ingredient Spelt Spaghetti")
            .withTime("25")
            .withGrains("80g, Spelt Spaghetti")
            .withVegetables("2 cups, Arugula (Salad Rockets)",
                    "300g, Tomatoes",
                    "300g, Zucchini",
                    "50g, Leek")
            .withProteins("50g, Egg")
            .withOthers("2 tbsp, Xucker Ketchup",
                    "2 tbsp, Italian Herbs",
                    "1 tbsp, Fresh Basil",
                    "2 tbsp, Salt",
                    "1 tbsp, Pepper",
                    "0.5 tbsp, Olive Oil")
            .withSteps("Thinly slice Tomatoes and Leek and shred your Zucchini.",
                    "Heat up Oil in a large Pan on a medium-high Level and roast Leek until golden.",
                    "Now add Zucchini.",
                    "When the Zucchini´s roasted, stir in Tomatoes and turn down Heat to a lower Level.",
                    "Let cook for 5-7 Minutes until it turn into a Sauce.",
                    "Meanwhile, prepare Spaghetti according to the Directions stated on the Package.",
                    "Then, add Ketchup, Basil, Italian Herbs and Salt, Pepper as desired.",
                    "Finally, stir in Arugula and cooked Noodles and serve on a Plate with Poached Egg, Parmesan and more fresh Basil.")
            .withGoals("Wholesome Wholemeal").build();

    // Manually added
    public static final Recipe BACON_SPINACH_CARAMELIZED_ONION_PASTA = new RecipeBuilder().withName("Bacon, Spinach Caramelized Onion Pasta")
            .withTime("25")
            .withGrains("170g, whole wheat penne pasta")
            .withVegetables("10g, large yellow onion diced", "1 cup, spinach")
            .withProteins("120g, chopped bacon")
            .withOthers("2 tbsp, butter",
                    "1 tbsp, brown sugar",
                    "1 tbsp, salt",
                    "1 tbsp, pepper",
                    "1 tbsp, garlic powder",
                    "0.5 cup, Parmesan cheese sprinkles")
            .withSteps("In a large skillet, add your bacon and cook for 1-2 mins until bacon is halfway done",
            "In that same pan, and some butter, sugar, spices, and onion; sautee until the onion becomes tender, and bacon starts to crisp up.",
            "Boil pasta in salted water until al dente",
            "Once the pasta is done, drain it loosely, but leave a tiny amount of water and add it to the skillet with the bacon, and onion mixture.",
            "Mix in the spinach and stir until tender",
            "Sprinkle with Parmesan before serving.")
            .withGoals("Wholesome Wholemeal").build();


    public static final Recipe HEALTHY_CHICKEN_SALAD_SANDWICH = new RecipeBuilder().withName("Healthy Chicken Salad Sandwich")
            .withTime("10")
            .withGrains("50g, whole wheat pita (toasted)")
            .withVegetables("120g, celery (chopped small)","55g, butter lettuce (chopped)")
            .withProteins("200g, chicken breasts (large, cooked)","368g, greek yogurt (non-fat)","34 grams, mixed nuts (chopped)")
            .withOthers("59 ml, mayonnaise",
                    "1 tbsp, garlic salt", "1 tbsp, Dijon mustard (whole grain dijon)")
            .withSteps("Toast one pita.",
                    "Prep ingredients by cooking, and then shredding or chopping 1/2 large chicken breast, chop 1-2 stalks celery to get 1/4 c chopped celery, quarter a handful of grapes to get 1/4 cup quartered grapes, prepare lettuce by washing/chopping it if needed. Also prepare nuts by chopping them if needed, making 1 tbsp chopped nuts.",
                    "Make chicken salad by adding shredded/chopped chicken to a small mixing bowl, then add 1/4 c Greek yogurt, 1/4 c mayo, 1/4 tsp garlic salt, 1 tsp Dijon mustard.",
                    "Mix together well. Once all incorporated, add in 1/4 c chopped celery, 1/4 c quartered red grapes, and 1 T chopped mixed nuts. Stir together.",
                    "Fill pita with chicken salad mixture and lettuce. Enjoy. Store chicken salad in airtight container for up to 5 days")
            .withGoals("Wholesome Wholemeal").build();

    public static final Recipe ALL_VEGGIE_SANDWICH = new RecipeBuilder().withName("All Veggie Sandwich")
            .withTime("10")
            .withGrains("300g, whole-wheat bread" )
            .withVegetables("1 cups, baby spinach leaves", "40g, thinly sliced cucumber", "20g, red bell pepper(seeded and sliced)",
                    "1 cup, fresh pea shoots or your favorite fresh sprouts")
            .withFruits("50g, ripe avocados")
            .withOthers("4 tbsp, plain hummus", "1 tbsp, cilantro leaves",
                    "2 tbsp, kosher salt and fresh black pepper")
            .withSteps("Spread 1 tablespoon of hummus on each slice of bread. Then add the avocado pulp of 1/2 avocado per slice and lightly mash with a fork. Depending on the size of your bread slices you may need to use little less avocado. I used about 1 avocado per sandwich.",
                    "Layer on spinach leaves, cucumber slices, red pepper, pea shoots, and cilantro leaves. Generously season with salt and pepper. Top with other slice of bread and enjoy.")
            .withGoals("Wholesome Wholemeal", "Herbivore").build();

    public static final Recipe SUMMER_ASIAN_SLAW = new RecipeBuilder().withName("Summer Asian Slaw")
            .withTime("25")
            .withVegetables("200g, shredded red and/or green cabbage",
                    "30g, red bell",
                    "20g, poblano",
                    "10g, scallions",
                    "15g, fresh basil (Thai basil, and/or mint)",
                    "15g, Thai chiles (dice)",
                    "10g, pepitas (with or without sesame seeds)")
            .withProteins("20g, toasted peanuts" , "3 tbsp, cashew or peanut butter")
            .withFruits("50g, ripe peach (thinly sliced)", "0.5 tbsp, lime juice")
            .withOthers("15g, chopped cilantro (including stems)", "1 tbsp, Sea salt", "0.5 tbsp. white miso paste",
                    "0.25 tbsp, sesame oil", "1 tbsp, water")
            .withSteps("Make the dressing: In a small bowl, whisk together the cashew butter, miso paste, lime juice, sesame oil, and ginger. Whisk in enough water to create a drizzable consistency. Set aside.",
                    "In a dry cast-iron skillet over medium heat, char the peppers whole, rotating until the edges have a little char, about 2 minutes per side. Remove. When cool to the touch, slice in half lengthwise, remove the stem, ribbing, and seeds and slice horizontally into thin strips.",
                    "In a large bowl, combine the cabbage, peppers, scallions, cilantro, basil, chiles, and ¾ of the dressing. Toss until combined. Add the remaining dressing, if desired, and season to taste with a few pinches of sea salt. Serve topped with the toasted nuts, seeds, and sliced peaches.")
            .withGoals("Herbivore").build();

    public static final Recipe AVOCADO_COUSCOUS_GRAPEFRUIT_SALAD_WITH_HONEY_LIME_DRESSING = new RecipeBuilder().withName("Avocado Couscous Grapefruit salad with honey lime dressing")
            .withTime("35")
            .withGrains("0.75 cups, uncooked whole wheat couscous", "100g, white beans" )
            .withProteins("0.75 cups, low sodium chicken stock" )
            .withFruits("300g, large avocados",
                    "200g, large ruby red grapefruit",
                    "3 tbsp, freshly squeezed lime juice (for dressing)")
            .withOthers("0.5 cup, crumbled feta cheese",
                    "3 tbsp, chopped fresh mint",
                    "3 tbsp, finely chopped fresh cilantro",
                    "2 tbsp, honey",
                    "2 tbsp, extra virgin olive oil",
                    "0.25 tbsp, kosher salt")
            .withSteps("In a small saucepan, bring the stock to a boil. Remove from the heat, stir in the couscous, then cover at let sit 5 minutes. Fluff with fork and set aside.",
                    "In a small bowl or large measuring cup, whisk together the dressing ingredients: lime juice, honey, olive oil, and salt, or shake all of the ingredients together in a mason jar with a tight-fitting lid.",
                    "In a large bowl, combine beans and couscous. Pour dressing over top and stir to combine. Add the avocados, grapefruit, feta, mint, and cilantro. Toss gently. Serve chilled or at room temperature.")
            .withGoals("Wholesome Wholemeal").build();

    public static final Recipe TERIYAKI_CHICKEN_NOODLE_BOWL = new RecipeBuilder().withName("Teriyaki chicken noodle bowl")
            .withTime("35")
            .withVegetables("50g, cloves garlic(minced)",
                    "0.25 tbsp, freshly grated ginger ")
            .withProteins("113g, boneless and skinless chicken thighs(cut into 1-inch chunks)")
            .withOthers("141g, refrigerated Yaki-Soba, seasoning sauce packets discarded*",
                    "4 tbsp, cornstarch", "0.08 cup, reduced sodium soy sauce", "0.08 cup, reduced sodium soy sauce",
                    "0.06 cup, brown sugar(packed)","0.5 tbsp, honey", "0.25 tbsp, olive oil",
                    "0.25 tbsp, sesame seeds",
                    "20g, green onion (thinly sliced)")
            .withSteps("In a large pot of boiling water, add Yaki-Soba until loosened, about 1-2 minutes; drain well.",
                    "In a small bowl, whisk together cornstarch and 1/4 cup water; set aside.",
                    "In a small saucepan over medium heat, add soy sauce, brown sugar, garlic, ginger, honey and 1 cup water; bring to a simmer. Stir in cornstarch mixture until thickened enough to coat the back of a spoon, about 2 minutes; let cool to room temperature. Reserve 1/4 cup and set aside.",
                    "In a gallon size Ziploc bag or large bowl, combine soy sauce mixture and chicken; marinate for at least 30 minutes to overnight, turning the bag occasionally. Drain the chicken from the marinade.",
                    "Heat olive oil in a large skillet over medium heat. Add chicken and cook until golden brown and cooked through, about 3-4 minutes; set aside.",
                    "Stir in Yaki-Soba and 1/4 cup reserved soy sauce mixture until well combined, about 2 minutes.",
                    "Serve immediately, garnished with sesame seeds and green onion, if desired.")
            .withGoals("Bulk like the Hulk").build();

    public static final Recipe OVERNIGHT_OATMEAL = new RecipeBuilder().withName("Overnight Oatmeal")
            .withTime("10")
            .withGrains("1 cup, steel cut oats" )
            .withFruits("1 cup, dried cranberries",
                    "1 cup, dried figs")
            .withOthers(" 4 cups, water",
                    "½ cup, milk" )
            .withSteps("In a slow cooker, combine all ingredients and set to low heat. Cover and let cook for 8 to 9 hours.",
                    "Stir and remove to serving bowls. This method works best if started before you go to bed.")
            .withGoals("Wholesome Wholemeal").build();

    //Manually added - Recipe's details found in {@code CommandTestUtil}
    public static final Recipe TURKEY_SANDWICH = new RecipeBuilder().withName(VALID_NAME_TURKEY_SANDWICH)
            .withTime(VALID_TIME_TURKEY_SANDWICH)
            .withGrains(VALID_GRAIN_TURKEY_SANDWICH)
            .withVegetables(VALID_VEGE_TURKEY_SANDWICH)
            .withProteins(VALID_PROTEIN_TURKEY_SANDWICH)
            .withFruits(VALID_FRUIT_TURKEY_SANDWICH)
            .withOthers(VALID_OTHER_TURKEY_SANDWICH)
            .withGoals(VALID_GOAL_GRAIN).withSteps(VALID_STEP_TURKEY_SANDWICH).build();

    public static final Recipe FISH = new RecipeBuilder().withName(VALID_NAME_FISH).withTime(VALID_TIME_FISH)
            .withGrains(VALID_GRAIN_FISH)
            .withVegetables(VALID_VEGE_FISH)
            .withProteins(VALID_PROTEIN_FISH)
            .withFruits(VALID_FRUIT_FISH)
            .withOthers(VALID_OTHER_FISH)
            .withGoals(VALID_GOAL_PROTEIN).withSteps(VALID_STEP_FISH).build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalRecipes() {} // prevents instantiation

    /**
     * Returns an {@code RecipeBook} with all the typical recipes.
     */
    public static RecipeBook getTypicalRecipeBook() {
        RecipeBook ab = new RecipeBook();
        for (Recipe recipe : getTypicalRecipes()) {
            ab.addRecipe(recipe);
        }
        return ab;
    }

    public static List<Recipe> getTypicalRecipes() {
        return new ArrayList<>(Arrays.asList(VEGAN_THAI_GREEN_CURRY_SOUP,THAI_BASIL_GROUND_BEEF_BOWL,
                BARLEY_PILAF,ASIAN_BBQ_CHICKEN, SWEET_AND_SOUR_CHICKEN,
                QUICK_CARROT_DAIKON_STIR_FRY,CHINESE_TOMATO_EGG_STIR_FRY,FIVE_INGREDIENT_SPELT_SPAGHETTI,BACON_SPINACH_CARAMELIZED_ONION_PASTA,HEALTHY_CHICKEN_SALAD_SANDWICH,ALL_VEGGIE_SANDWICH,SUMMER_ASIAN_SLAW,AVOCADO_COUSCOUS_GRAPEFRUIT_SALAD_WITH_HONEY_LIME_DRESSING,TERIYAKI_CHICKEN_NOODLE_BOWL,OVERNIGHT_OATMEAL
        ));
    }
}
