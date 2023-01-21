package me.itsgustavo.damageindicators;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author itsgustavo
 */
public class DamagePlugin extends JavaPlugin {

    private ProtocolManager protocolManager;

    @Override
    public void onLoad() {
        protocolManager = ProtocolLibrary.getProtocolManager();
    }

    @Override
    public void onEnable() {
        init();
    }

    public void init(){
        protocolManager.addPacketListener(new PacketAdapter(this, ListenerPriority.NORMAL, PacketType.Play.Server.ENTITY_METADATA) {
            @Override
            public void onPacketSending(final PacketEvent event) {
                try {
                    if(event.isPlayerTemporary()) return;
                    Player player = event.getPlayer();
                    int id = event.getPacket().getIntegers().read(0);
                    Entity entity = player.getWorld().getEntities()
                            .stream()
                            .filter(other -> other.getEntityId() == id)
                            .findAny()
                            .orElse(null);
                    if(entity == null) return;
                    if(entity == player) return;
                    if(!(entity instanceof HumanEntity)) return;
                    if(entity.getPassengers().contains(player)) return;
                    event.setPacket(event.getPacket().deepClone());
                    event.getPacket().getWatchableCollectionModifier()
                            .read(0)
                            .stream()
                            .filter(w -> w.getIndex() == 8)
                            .forEach(w -> w.setValue(0.1F));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
