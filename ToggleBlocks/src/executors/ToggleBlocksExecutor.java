package executors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import toggleblocks.PlayerMessage;
import toggleblocks.Region;
import toggleblocks.RegionManager;
import toggleblocks.ToggleBlocks;

public class ToggleBlocksExecutor implements CommandExecutor {
    private ToggleBlocks plugin;
    
    public ToggleBlocksExecutor(ToggleBlocks plugin) {
        this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player))
            return true;

        Player player = (Player) sender;

        if(args.length != 1) {
            player.sendMessage(PlayerMessage.getInvalidArguments(command.getUsage()));
            return true;
        }
                   
        RegionManager regionManager = plugin.getRegionManager();
        if(regionManager.getRegion(player.getPlayerListName(), args[0]) != null) {
            player.sendMessage(PlayerMessage.getRegionExists(args[0]));
            return true;
        }
        
        Region region = new Region(plugin, player.getPlayerListName(), args[0]);
        regionManager.addRegion(region);
        player.sendMessage(PlayerMessage.getRegionCreated(args[0]));
        
        if(regionManager.getEditRegion(player) != null)
            player.sendMessage(PlayerMessage.getNoEditMode(regionManager.getEditRegion(player).getName()));
        
        regionManager.setEditRegion(player, region);
        player.sendMessage(PlayerMessage.getYesEditMode(args[0]));

        return true;
    }
    
}