package models;

import java.util.Set;

public class GenericSetClass<T> {
    private Set<T> set;

    public GenericSetClass() {}

    public Set<T> getSet() {
        return set;
    }

    public void setSet(Set<T> set) {
        this.set = set;
    }
}
