package minegame159.meteorclient.macros;

import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listenable;
import me.zero.alpine.listener.Listener;
import minegame159.meteorclient.events.KeyEvent;
import net.minecraft.client.MinecraftClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Macro implements Listenable {
    public String name;
    public List<String> commands = new ArrayList<>();
    public int key = -1;

    public void addCommand(String command) {
        commands.add(command);
    }

    public void removeCommand(int i) {
        commands.remove(i);
    }

    @EventHandler
    private transient Listener<KeyEvent> onKey = new Listener<>(event -> {
        if (event.push && event.key == key && MinecraftClient.getInstance().currentScreen == null) {
            for (String command : commands) {
                MinecraftClient.getInstance().player.sendChatMessage(command);
            }
            event.cancel();
        }
    });

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Macro macro = (Macro) o;
        return Objects.equals(name, macro.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}