package telepads;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.material.Wool;

public class TelepadFromExecutor implements CommandExecutor {
    private TelepadManager telepadManager;

    public TelepadFromExecutor(TelepadManager telepadManager) {
        this.telepadManager = telepadManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;
        
        if(args.length != 1) {
            player.sendMessage(PlayerMessage.invalidArguments(command.getUsage()));
            return true;
        }
        
        Telepad telepad = telepadManager.getTelepad(player.getPlayerListName(), args[0]);
        if(telepad == null) {
            player.sendMessage(PlayerMessage.getMissingTelepad(args[0]));
            return true;
        }
                
        telepad.setFrom(player.getTargetBlock(null, 6).getRelative(BlockFace.UP).getLocation());
        telepadManager.saveFrom(telepad);
        player.sendMessage(PlayerMessage.telepadFromUpdated(args[0]));

        return true;
    }

}
