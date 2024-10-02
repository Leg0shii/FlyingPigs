package de.legoshi.flyingpigs;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;

@Getter
@Setter
@RequiredArgsConstructor
public class PlayerObject {

    private final Player player;
    private int id;
    private Pig pig;

}
