# FairItemPickup
Vanilla Minecraft item pickup favours the player who has been online longest, this plugin equalises that.

When a player picks up an item, the event will be cancelled and a random player within range of picking up the item will be chosen instead.

A known drawback of the current implementation is that the "flying" animation wherein the item flies towards the player does not occur. PRs are welcome if you can think of an elegant way of implementing this.