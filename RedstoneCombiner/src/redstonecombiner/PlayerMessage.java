package redstonecombiner;

import org.bukkit.block.Block;
import puzzlepack.BaseMessage;

public class PlayerMessage extends BaseMessage {    
    
    public static String combinerExists(String name) {
        return ERROR + "Redstone combiner '" + HIGHLIGHT + name + ERROR + "' already exists!";
    }

    public static String combinerCreated(String name) {
        return NORMAL + "Redstone combiner '" + HIGHLIGHT + name + NORMAL + "' was created!";
    }

    public static String missingCombiner(String name) {
        return ERROR + "Redstone combiner '" + HIGHLIGHT + name + ERROR + "' doesn't exist!";
    }

    public static String combinerAddLink(String name) {
        return NORMAL + "A link was added to combiner '" + HIGHLIGHT + name + NORMAL + "'!";
    }

    public static String combinerRemoved(String name) {
        return NORMAL + "Combiner '" + HIGHLIGHT + name + NORMAL + "' and all its links was removed!";
    }

    public static String linkRemoved(String name) {
        return NORMAL + "A link has been removed from combiner '" + HIGHLIGHT + name + NORMAL + "'!";
    }

    public static String missingLink(String name) {
        return ERROR + "A link for combiner '" + HIGHLIGHT + name + ERROR + "' doesn't exist at this block!";
    }

    public static String headerList() {
        return HIGHLIGHT + "========== Redstone Combiners ==========";
    }

    public static String invalidBlock() {
        return ERROR + "You must look at a sign when creating a combiner or link!";
    }

    public static String combinerRenamed(String originalName, String newName) {
        return NORMAL + "Redstone combiner '" + HIGHLIGHT + originalName + NORMAL + "' was renamed to '" + HIGHLIGHT + newName + NORMAL + "'!"; 
    }
    
     public static String infoHeader() {
        return HIGHLIGHT + "========== Combiner information ==========";
    }
    
    public static String missingInfo(Block block) {
        return ERROR + "No combiner information at this location (" + HIGHLIGHT + block.getX() + ERROR + ", "
                                                            + HIGHLIGHT + block.getY() + ERROR + ", "
                                                            + HIGHLIGHT + block.getZ() + ERROR + ")!";
    }

    public static String info(String name) {
        return NORMAL + " Name: " + HIGHLIGHT + name; 
    }
    
    public static String blockInfo(Block block) {
        return " Block: (" + HIGHLIGHT + block.getX() + NORMAL + ", "
                           + HIGHLIGHT + block.getY() + NORMAL + ", "
                           + HIGHLIGHT + block.getZ() + NORMAL + ")!";
    }
}
