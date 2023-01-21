# gus_DamageIndicators
Plugin blocks the use of mods that reveal the player's health.
Only player hp is replaced, if you want to hide mob hp as well please change HumanEntity to LivingEntity in code.

How does the plugin work?
The server sends the metadata to the players, this plugin simply modifies this data and sets the player's life to 0.1.
Please don't set the life below 0.1 because the player may then be invisible because other clients will consider it dead because the player with 0.0 hp is dead.
I'm done.
The plugin is used by one server and the owner praised it because everything works fine.
The plugin was tested only on 1.16 and it doesn't work on older/newer versions, if you have a problem with it, write to me on discord: itsgustavo#6720

Goodbye labymod.
