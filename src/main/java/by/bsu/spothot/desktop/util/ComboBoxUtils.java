package by.bsu.spothot.desktop.util;

import javafx.scene.control.ComboBox;

/**
 * Created by Dmitry on 2/2/14.
 */
public class ComboBoxUtils
{
    public static String getComboBoxStringValue(ComboBox<String> comboBox)
    {
        return comboBox.getValue() == null ? comboBox.getPromptText() :
                comboBox.getSelectionModel().getSelectedItem();
    }

    public static Integer getComboBoxIntegerValue(ComboBox<String> comboBox)
    {
        return comboBox.getValue() == null ? Integer.valueOf(comboBox.getPromptText()) :
                Integer.valueOf(comboBox.getSelectionModel().getSelectedItem());
    }
}
