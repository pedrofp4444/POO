package MakeItFit.activities;

public interface ActivityInterface {

    int calculateCaloricWaste();

    int getUserCode();

    int getCode();

    int getExpectedDuration();

    int getDuration();

    String getDesignation();

    void setUserCode(int userCode);

    void setCode(int code);

    void setDuration(int duration);

    void setExpectedDuration(int expectedDuration);

    void setDesignation(String designation);

    String toString();

    public boolean equals(Object o);
}
