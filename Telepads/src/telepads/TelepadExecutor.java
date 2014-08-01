package telepads;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TelepadExecutor implements CommandExecutor {
    private TelepadManager telepadManager;

    public TelepadExecutor(TelepadManager telepadManager) {
        this.telepadManager = telepadManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;
        
        if(args.length != 1) {
            player.sendMessage(PlayerMessage.getInvalidArguments(command.getUsage()));
            return true;
        }
        
        if(!telepadManager.isAvailable(args[0])) {
            player.sendMessage(PlayerMessage.getTelepadExist(args[0]));
            return true;
        }
        
        telepadManager.createTelepad(args[0], player.getPlayerListName());
        player.sendMessage(PlayerMessage.getTelepadCreated(args[0]));

        return true;
    }

}
