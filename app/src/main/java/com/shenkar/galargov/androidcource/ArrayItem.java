package com.shenkar.galargov.androidcource;

public class ArrayItem {
    private Class activity;
    private String label;
    private String packageName;

    public ArrayItem(String label, Class activity) {
        this.label = label;
        this.activity = activity;
    }

    public ArrayItem(String label, String packageName) {
        this.label = label;
        this.packageName = packageName;
    }

    @Override
    public String toString() {
        if (activity != null) {
            return "Open " + label;
        }
        return label;
    }

    public String getLabel() {
        return label;
    }

    /**
     * optional parameter, to launch a different app (as an example)
     */
    public String getPackageName() {
        return packageName;
    }

    public Class getActivity() {
        return activity;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setLabel(String label) {

        this.label = label;
    }

    public void setActivity(Class activity) {

        this.activity = activity;
    }
}
