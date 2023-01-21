# gus_DamageIndicators
Plugin <b>blocks</b> the use of mods that reveal the <b>player's health</b>.<br>
You need <b>ProtocolLib</b> to use.
Only player hp is replaced, if you want to hide mob hp as well please change <b>HumanEntity</b> to <b>LivingEntity</b> in code.<br>

How does the plugin work?<br>
The server sends the metadata to the players, this plugin simply modifies this data and sets the player's life to 0.1.<br>
Please don't <b>set the life below 0.1</b> because the player may then be invisible because other clients will consider it dead because <b>the player with 0.0 hp is dead</b>.
<br>
<br>
The plugin is used by one server and the owner praised it because everything works fine.<br>
The plugin was tested only on <b>1.16</b> and it doesn't work on <b>older/newer versions</b>, if you have a problem with it, write to me on discord: <b>itsgustavo#6720</b><br>
<br>
Goodbye labymod.
