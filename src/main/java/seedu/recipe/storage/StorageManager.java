package seedu.recipe.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.recipe.commons.core.LogsCenter;
import seedu.recipe.commons.exceptions.DataConversionException;
import seedu.recipe.model.ReadOnlyCookedRecordBook;
import seedu.recipe.model.ReadOnlyRecipeBook;
import seedu.recipe.model.ReadOnlyUserPrefs;
import seedu.recipe.model.UserPrefs;

/**
 * Manages storage of RecipeBook data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private RecipeBookStorage recipeBookStorage;
    private CookedRecordBookStorage cookedRecordStorage;
    private UserPrefsStorage userPrefsStorage;


    public StorageManager(RecipeBookStorage recipeBookStorage, CookedRecordBookStorage cookedRecordStorage,
                          UserPrefsStorage userPrefsStorage) {
        super();
        this.recipeBookStorage = recipeBookStorage;
        this.cookedRecordStorage = cookedRecordStorage;
        this.userPrefsStorage = userPrefsStorage;
    }

    // ================ UserPrefs methods ==============================

    @Override
    public Path getUserPrefsFilePath() {
        return userPrefsStorage.getUserPrefsFilePath();
    }

    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException {
        return userPrefsStorage.readUserPrefs();
    }

    @Override
    public void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException {
        userPrefsStorage.saveUserPrefs(userPrefs);
    }


    // ================ RecipeBook methods ==============================

    @Override
    public Path getRecipeBookFilePath() {
        return recipeBookStorage.getRecipeBookFilePath();
    }

    @Override
    public Optional<ReadOnlyRecipeBook> readRecipeBook() throws DataConversionException, IOException {
        return readRecipeBook(recipeBookStorage.getRecipeBookFilePath());
    }

    @Override
    public Optional<ReadOnlyRecipeBook> readRecipeBook(Path filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return recipeBookStorage.readRecipeBook(filePath);
    }

    @Override
    public void saveRecipeBook(ReadOnlyRecipeBook recipeBook) throws IOException {
        saveRecipeBook(recipeBook, recipeBookStorage.getRecipeBookFilePath());
    }

    @Override
    public void saveRecipeBook(ReadOnlyRecipeBook recipeBook, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        recipeBookStorage.saveRecipeBook(recipeBook, filePath);
    }

    // ================ CookedRecordBook methods ==============================

    @Override
    public Path getCookedRecordBookFilePath() {
        return cookedRecordStorage.getCookedRecordBookFilePath();
    }

    @Override
    public Optional<ReadOnlyCookedRecordBook> readCookedRecordBook() throws DataConversionException, IOException {
        return readCookedRecordBook(cookedRecordStorage.getCookedRecordBookFilePath());
    }

    @Override
    public Optional<ReadOnlyCookedRecordBook> readCookedRecordBook(Path filePath) throws DataConversionException,
            IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return cookedRecordStorage.readCookedRecordBook(filePath);
    }

    @Override
    public void saveCookedRecordBook(ReadOnlyCookedRecordBook cookedRecordBook) throws IOException {
        saveCookedRecordBook(cookedRecordBook, cookedRecordStorage.getCookedRecordBookFilePath());
    }

    @Override
    public void saveCookedRecordBook(ReadOnlyCookedRecordBook cookedRecordBook, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        cookedRecordStorage.saveCookedRecordBook(cookedRecordBook, filePath);
    }

}
