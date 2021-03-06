package redstonecombiner;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.block.Block;

public class CombinerManager {
    private Map<String, Combiner> combiners = new LinkedHashMap();
        
    public void addCombiner(Combiner combiner) {
        combiners.put(combiner.getName(), combiner);      
    }
    
    public Combiner getCombiner(String playerName, String name) {
        Combiner combiner = combiners.get(name);
        if(combiner == null)
            return null;
        
        if(combiner.getPlayerName().equalsIgnoreCase(playerName))
            return combiner;
        
        return null;
    }
    
    public void renameCombiner(Combiner combiner, String newName) {
        Combiner newCombiner = new Combiner(combiner.getPlayerName(), newName, combiner.getToggleBlock());
        for(Block link : combiner.getLinks()) {
            newCombiner.addLink(link);
        }
        
        removeCombiner(combiner);
        addCombiner(newCombiner);
    }
    
    public List<Combiner> getCombiners() {
        return new ArrayList(combiners.values());
    }

    public void removeCombiner(Combiner combiner) {
        combiners.remove(combiner.getName());
    }
    
    public Combiner getCombinerByLink(String playerName, Block block) {
        for(Combiner combiner : combiners.values())
            for(Block link : combiner.getLinks())
                if(link.equals(block))
                    return combiner;
        
        return null;
    }
    
    public Combiner getCombinerByToggleBlock(String playerName, Block block) {
        for(Combiner combiner : combiners.values())
            if(combiner.getToggleBlock().equals(block))
                return combiner;
        
        return null;
    }
}
