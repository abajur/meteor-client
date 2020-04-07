package minegame159.meteorclient.accountsfriends;

import minegame159.meteorclient.gui.screens.WindowScreen;
import minegame159.meteorclient.gui.widgets.WButton;
import minegame159.meteorclient.gui.widgets.WGrid;
import minegame159.meteorclient.gui.widgets.WLabel;
import minegame159.meteorclient.gui.widgets.WTextBox;

public class AddAccountScreen extends WindowScreen {
    public AddAccountScreen() {
        super("Add Account");

        WGrid grid = add(new WGrid(4, 4, 2));

        WLabel emailL = new WLabel("Email:");
        WTextBox emailT = new WTextBox("", 200);
        emailT.setFocused(true);
        grid.addRow(emailL, emailT);

        WLabel passwordL = new WLabel("Password:");
        WTextBox passwordT = new WTextBox("", 200);
        grid.addRow(passwordL, passwordT);

        WButton add = add(new WButton("Add"));
        add.boundingBox.fullWidth = true;
        add.action = () -> {
            AccountManager.INSTANCE.add(new Account(emailT.text, passwordT.text));
            onClose();
        };

        layout();
    }
}