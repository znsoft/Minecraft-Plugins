package area;

import areacollider.PlayerMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AreaRenameExecutor implements CommandExecutor {
    private AreaManager areaManager;
    
    public AreaRenameExecutor(AreaManager areaManager) {
        this.areaManager = areaManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))
            return true;
        
        Player player = (Player)sender;
                
        if(args.length != 2) {
            player.sendMessage(PlayerMessage.getInvalidArguments(command.getUsage()));
            return true;
        }
        
        Area area = areaManager.getArea(player.getName(), args[0]);
        if(area == null) {
            player.sendMessage(PlayerMessage.getMissingArea(args[0]));
            return true;
        }
        
        if(areaManager.getArea(player.getName(), args[1]) != null) {
            player.sendMessage(PlayerMessage.getAreaExists(args[1]));
            return true;
        }
        
        areaManager.renameArea(area, args[1]);
        player.sendMessage(PlayerMessage.getAreaRenamed(area.getName(), args[1]));
        
        return true;
    }
}
