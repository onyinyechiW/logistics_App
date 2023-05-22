package shita.repository;

import shita.model.Package;

import java.util.ArrayList;
import java.util.List;

public class PackageRepositoryImplementation implements  PackageRepository{

    private int count;
    private List<Package> packages=new ArrayList<>();



    public Package save(Package aPackage) {
        boolean isSaved = aPackage.getId()!=0;
        if (isSaved)update(aPackage);else saveNew(aPackage);
        return aPackage;
    }

    private void saveNew(Package aPackage){
        packages.add(aPackage);
        aPackage.setId(generateId());
        count++;
    }

    private void update(Package aPackage){
//        Package savedPackage = findById(aPackage.getId());
//        int indexOfSavedPackage = packages.indexOf(savedPackage);
//        packages.set(indexOfSavedPackage,aPackage);

        Package savedPackage = findById(aPackage.getId());
        packages.remove(savedPackage);
        packages.add(aPackage);
    }

    private int generateId() {
        return    count+1;
    }

    public void delete(Package aPackage) {
        packages.remove(aPackage);
    }

    public void delete(int id) {
        packages.remove(id);
    }

    public  List<Package> findAll() {
        return null;
    }

    public Package findById(int id) {
        for(Package aPackage: packages) if (aPackage.getId() == id) return aPackage;
        return null;
    }

    public long count() {
        return count;
    }
}

