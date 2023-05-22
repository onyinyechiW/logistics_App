package tdd;

import shita.model.Package;
import shita.repository.PackageRepository;
import shita.repository.PackageRepositoryImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PackageRepositoryImplementationTest {
    private PackageRepository packageRepository;

    @BeforeEach
    public void setUp() {
        packageRepository = new PackageRepositoryImplementation();
    }

    @Test
    @DisplayName("Create new package test")
    public void saveOnePackage_countIsOneTest() {
        Package aPackage = new Package();
        assertEquals(0, packageRepository.count());
        packageRepository.save(aPackage);
        assertEquals(1, packageRepository.count());
    }

    @Test
    @DisplayName("Generate id test")
    public void saveOnePackage_IdIsOneTest() {
        Package aPackage = new Package();
        assertEquals(0, aPackage.getId());
        Package savedPackage = packageRepository.save(aPackage);
        assertEquals(1, savedPackage.getId());
    }

    @Test
    @DisplayName("Find by id test")
    public void saveOnePackage_findPackageId_returnsSavedPackageTest() {
        Package apackage = new Package();
        Package aPackage = new Package();
        aPackage.setPayOnDelivery(true);
        packageRepository.save(aPackage);
        Package foundPackage = packageRepository.findById(1);
        assertEquals(1, foundPackage.getId());
        assertTrue(foundPackage.isPayOnDelivery());
        assertEquals(aPackage, foundPackage);

    }

    @Test
    @DisplayName("Update test")
    public void saveTwoItemsWithSameId_countIsOneTest() {
        Package aPackage = new Package();
        aPackage.setWeightGrammes(34);
        packageRepository.save(aPackage);
        Package savedAPackage = packageRepository.findById(1);
        assertEquals(aPackage, savedAPackage);

        Package secondPackage = new Package();
        secondPackage.setId(1);
        aPackage.setWeightGrammes(22);
        packageRepository.save(secondPackage);
        Package foundPackage = packageRepository.findById(1);

        assertEquals(foundPackage, secondPackage);
        assertNotEquals(foundPackage, aPackage);

    }

    @Test
    public void saveThreeItemsAndDeleteOne() {
        Package apackage = new Package();
        Package aPackage = new Package();
        Package pack = new Package();
        Package pa = new Package();
        Package p = new Package();

        packageRepository.save(apackage);
        packageRepository.save(aPackage);
        packageRepository.save(pack);

        packageRepository.delete(2);

        packageRepository.save(pa);
        packageRepository.save(p);

        long count = packageRepository.count();

        System.out.println(count);
        System.out.println(packageRepository.findById(1));


    }
}