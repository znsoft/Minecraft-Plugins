package toggleblocks;

import basepack.BaseItem;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.block.Block;

public class Region extends BaseItem {
    private LinkBlock linkBlock;   
    private List<ToggleBlock> toggleBlocks = new ArrayList();
    
    
    public Region(String name, String playerName) {
        super(name, playerName);
    }
            
    public void addBlock(ToggleBlock toggleBlock) {
        toggleBlocks.add(toggleBlock);
    }
    
    public boolean removeBlock(Block block) {
        for(ToggleBlock toggleBlock : toggleBlocks) {
            if(block.equals(toggleBlock.getBlock()))
                return toggleBlocks.remove(toggleBlock);
        }
        
        return false;
    }
    
    public void setLinkBlock(LinkBlock linkBlock) {
        this.linkBlock = linkBlock;
    }
            
    public LinkBlock getLinkBlock() {
        return linkBlock;
    }
        
    public boolean isLinkBlock(Block block) {
        if(linkBlock == null)
            return false;
        
        return linkBlock.getBlock().equals(block);
    }
    
    public List<ToggleBlock> getToggleBlocks() {
        return toggleBlocks;
    }
    
    public boolean hasBlock(Block block) {
        for(ToggleBlock toggleBlock : toggleBlocks)
            if(toggleBlock.getBlock().equals(block))
                return true;
        
        return false;
    }
            
    public void toggle() {
        for(ToggleBlock block : toggleBlocks)
            block.toggle();
    }
    
    public void toggleOn() {        
        for(ToggleBlock block : toggleBlocks)
            block.toggleOn();
    }
    
    public void toggleOff() {        
        for(ToggleBlock block : toggleBlocks)
            block.toggleOff();
    }
}
