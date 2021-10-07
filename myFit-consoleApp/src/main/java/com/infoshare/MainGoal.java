package com.infoshare;

import java.util.Objects;

public class MainGoal {
    private String purpose;

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public MainGoal(String purpose) {
        this.purpose = purpose;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainGoal mainGoal = (MainGoal) o;
        return Objects.equals(purpose, mainGoal.purpose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purpose);
    }
}
