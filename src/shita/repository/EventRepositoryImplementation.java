package shita.repository;

import shita.model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventRepositoryImplementation {
    private int count;
    private List<Event> events =new ArrayList<>();



    public Event save(Event aEvent) {
        boolean isSaved = aEvent.getId()!=0;
        if (isSaved)update(aEvent);else saveNew(aEvent);
        return aEvent;
    }

    private void saveNew(Event aEvent){
        events.add(aEvent);
        aEvent.setId(generateId());
        count++;
    }

    private void update(Event aEvent){
//        Package savedPackage = findById(aPackage.getId());
//        int indexOfSavedPackage = packages.indexOf(savedPackage);
//        packages.set(indexOfSavedPackage,aPackage);

        Event savedEvent = findById(aEvent.getId());
        events.remove(savedEvent);
        events.add(aEvent);
    }

    private int generateId() {
        return    count+1;
    }

    public void delete(Event aEvent) {
        events.remove(aEvent);
    }

    public void delete(int id) {
        events.remove(id);
    }

    public List<Event> findAll() {
        return null;
    }

    public Event findById(int id) {
        for(Event aEvent: events) if (aEvent.getId() == id) return aEvent;
        return null;
    }

    public long count() {
        return count;
    }
}


