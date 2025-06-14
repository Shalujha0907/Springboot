package com.practice.FirstSpringBootProject;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

public class FirstNamePropertyEditor extends PropertyEditorSupport {

    @Override
    public void  setAsText(String text) throws IllegalArgumentException{
        setValue(text.trim().toUpperCase());

    }
}
