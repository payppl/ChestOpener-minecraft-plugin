package listener;

import classes.CaseAPI;
import inventories.precasetier;
import CaseOpener.Main;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


public class playersevents implements Listener{
	static Main plugin;
	public playersevents(Main pl) {
        playersevents.plugin = pl;
	}
	/*
	@EventHandler
    public void BlockInvenotry(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		String keyname1 = plugin.getConfig().getString("Names.Tier 1 key.Name").replace("&", "§");
		String keyname2 = plugin.getConfig().getString("Names.Tier 2 key.Name").replace("&", "§");
		String keyname3 = plugin.getConfig().getString("Names.Tier 3 key.Name").replace("&", "§");
		String keyname4 = plugin.getConfig().getString("Names.Tier 4 key.Name").replace("&", "§");
		String keyname5 = plugin.getConfig().getString("Names.Tier 5 key.Name").replace("&", "§");
		String casename1 = plugin.getConfig().getString("Names.Tier 1 Case.Name").replace("&", "§");
		String casename2 = plugin.getConfig().getString("Names.Tier 2 Case.Name").replace("&", "§");
		String casename3 = plugin.getConfig().getString("Names.Tier 3 Case.Name").replace("&", "§");
		String casename4 = plugin.getConfig().getString("Names.Tier 4 Case.Name").replace("&", "§");
		String casename5 = plugin.getConfig().getString("Names.Tier 5 Case.Name").replace("&", "§");
		if (e.getView().getTitle().equals(plugin.getConfig().getString("Names.Tier 1 Case.Name").replace("&", "§") + " - preview")) {
			e.setCancelled(true);
				if (p.getItemInHand().getItemMeta().getDisplayName().equals(keyname1)) {
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("OPEN_CASE").replace("&", "§"))) {
					if (p.getItemInHand().getAmount() > 1) {
						p.setItemInHand(CaseAPI.newItem(p.getItemInHand().getType(), p.getItemInHand().getAmount() - 1, p.getItemInHand().getItemMeta().getDisplayName()));

					} else if (p.getItemInHand().getAmount() == 1) {
						ItemStack is = new ItemStack(Material.AIR);
						p.setItemInHand(is);
					}
					CaseAPI.openCase(p, 1);
				} else {
				p.sendMessage(plugin.getConfig().getString("WARNING_DO_NOT_HAVE_KEYS").replace("&", "§"));
					p.closeInventory();
				}

			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("CLOSE_CASE").replace("&", "§"))) {
				p.closeInventory();
				p.playSound(p.getLocation(), Sound.BLOCK_CHEST_CLOSE, 1 ,1);
			}
		}
		if (e.getView().getTitle().equals(plugin.getConfig().getString("Names.Tier 2 Case.Name").replace("&", "§") + " - preview")) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("OPEN_CASE").replace("&", "§"))) {
				if (p.getItemInHand().getItemMeta().getDisplayName().equals(keyname2)) {
					if (p.getItemInHand().getAmount() > 1) {
						p.setItemInHand(CaseAPI.newItem(p.getItemInHand().getType(), p.getItemInHand().getAmount() - 1, p.getItemInHand().getItemMeta().getDisplayName()));

					} else if (p.getItemInHand().getAmount() == 1) {
						ItemStack is = new ItemStack(Material.AIR);
						p.setItemInHand(is);
					}
				} else {
					p.sendMessage(plugin.getConfig().getString("WARNING_DO_NOT_HAVE_KEYS").replace("&", "§"));
					p.closeInventory();
				}

			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("CLOSE_CASE").replace("&", "§"))) {
				p.closeInventory();
				p.playSound(p.getLocation(), Sound.BLOCK_CHEST_CLOSE , 1 ,1);
			}
		}
		if (e.getView().getTitle().equals(plugin.getConfig().getString("Names.Tier 3 Case.Name").replace("&", "§")+ " - preview")) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("OPEN_CASE").replace("&", "§"))) {
				if (p.getItemInHand().getItemMeta().getDisplayName().equals(keyname3)) {
					if (p.getItemInHand().getAmount() > 1) {
						p.setItemInHand(CaseAPI.newItem(p.getItemInHand().getType(), p.getItemInHand().getAmount() - 1, p.getItemInHand().getItemMeta().getDisplayName()));

					} else if (p.getItemInHand().getAmount() == 1) {
						ItemStack is = new ItemStack(Material.AIR);
						p.setItemInHand(is);
					}
				} else {
					p.sendMessage(plugin.getConfig().getString("WARNING_DO_NOT_HAVE_KEYS").replace("&", "§"));
					p.closeInventory();
				}

			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("CLOSE_CASE").replace("&", "§"))) {
				p.closeInventory();
				p.playSound(p.getLocation(), Sound.BLOCK_CHEST_CLOSE, 1 ,1);
			}
		}
		if (e.getView().getTitle().equals(plugin.getConfig().getString("Names.Tier 4 Case.Name").replace("&", "§")+ " - preview")) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("OPEN_CASE").replace("&", "§"))) {
				if (p.getItemInHand().getItemMeta().getDisplayName().equals(keyname4)) {
					if (p.getItemInHand().getAmount() > 1) {
						p.setItemInHand(CaseAPI.newItem(p.getItemInHand().getType(), p.getItemInHand().getAmount() - 1, p.getItemInHand().getItemMeta().getDisplayName()));

					} else if (p.getItemInHand().getAmount() == 1) {
						ItemStack is = new ItemStack(Material.AIR);
						p.setItemInHand(is);
					}
				} else {
					p.sendMessage(plugin.getConfig().getString("WARNING_DO_NOT_HAVE_KEYS").replace("&", "§"));
					p.closeInventory();
				}

			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("CLOSE_CASE").replace("&", "§"))) {
				p.closeInventory();
				p.playSound(p.getLocation(), Sound.BLOCK_CHEST_CLOSE, 1 ,1);
			}
		}
		if (e.getView().getTitle().equals(plugin.getConfig().getString("Names.Tier 5 Case.Name").replace("&", "§")+ " - preview")) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("OPEN_CASE").replace("&", "§"))) {
				if (p.getItemInHand().getItemMeta().getDisplayName().equals(keyname5)) {
					if (p.getItemInHand().getAmount() > 1) {
						p.setItemInHand(CaseAPI.newItem(p.getItemInHand().getType(), p.getItemInHand().getAmount() - 1, p.getItemInHand().getItemMeta().getDisplayName()));

					} else if (p.getItemInHand().getAmount() == 1) {
						ItemStack is = new ItemStack(Material.AIR);
						p.setItemInHand(is);
					}
				} else {
					p.sendMessage(plugin.getConfig().getString("WARNING_DO_NOT_HAVE_KEYS").replace("&", "§"));
					p.closeInventory();
				}

			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("CLOSE_CASE").replace("&", "§"))) {
				p.closeInventory();
				p.playSound(p.getLocation(), Sound.BLOCK_CHEST_CLOSE, 1 ,1);
			}
		}
    }
	*/
	@EventHandler
	public void BlockCase(InventoryClickEvent e) {
		if (e.getView().getTitle().equals(plugin.getConfig().getString("Names.Tier 1 Case.Name").replace("&", "§")))
		{
			e.setCancelled(true);
		}
		else if(e.getView().getTitle().equals(plugin.getConfig().getString("Names.Tier 2 Case.Name").replace("&", "§")))
		{
			e.setCancelled(true);
		}
		else if(e.getView().getTitle().equals(plugin.getConfig().getString("Names.Tier 3 Case.Name").replace("&", "§")))
		{
			e.setCancelled(true);
		}
		else if(e.getView().getTitle().equals(plugin.getConfig().getString("Names.Tier 4 Case.Name").replace("&", "§")))
		{
			e.setCancelled(true);
		}
		else if(e.getView().getTitle().equals(plugin.getConfig().getString("Names.Tier 5 Case.Name").replace("&", "§")))
		{
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void openchest(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		String keyname1 = plugin.getConfig().getString("Names.Tier 1 key.Name").replace("&", "§");
		String keyname2 = plugin.getConfig().getString("Names.Tier 2 key.Name").replace("&", "§");
		String keyname3 = plugin.getConfig().getString("Names.Tier 3 key.Name").replace("&", "§");
		String keyname4 = plugin.getConfig().getString("Names.Tier 4 key.Name").replace("&", "§");
		String keyname5 = plugin.getConfig().getString("Names.Tier 5 key.Name").replace("&", "§");
		String casename1 = plugin.getConfig().getString("Names.Tier 1 Case.Name").replace("&", "§");
		String casename2 = plugin.getConfig().getString("Names.Tier 2 Case.Name").replace("&", "§");
		String casename3 = plugin.getConfig().getString("Names.Tier 3 Case.Name").replace("&", "§");
		String casename4 = plugin.getConfig().getString("Names.Tier 4 Case.Name").replace("&", "§");
		String casename5 = plugin.getConfig().getString("Names.Tier 5 Case.Name").replace("&", "§");
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
			if (p.getItemInHand().getType() == Material.CHEST) {
				if (p.getItemInHand().getItemMeta().getDisplayName() != null && p.getItemInHand().getItemMeta().getDisplayName().equals(casename1)) {
					e.setCancelled(true);
					p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 1, 1);
					precasetier.openprecasetier(p, 1);
				}
				if (p.getItemInHand().getItemMeta().getDisplayName() != null && p.getItemInHand().getItemMeta().getDisplayName().equals(casename2)) {
					e.setCancelled(true);
					p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 1, 1);
					precasetier.openprecasetier(p, 2);
				}
				if (p.getItemInHand().getItemMeta().getDisplayName() != null && p.getItemInHand().getItemMeta().getDisplayName().equals(casename3)) {
					e.setCancelled(true);
					p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 1, 1);
					precasetier.openprecasetier(p, 3);
				}
				if (p.getItemInHand().getItemMeta().getDisplayName() != null && p.getItemInHand().getItemMeta().getDisplayName().equals(casename4)) {
					e.setCancelled(true);
					p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN , 1, 1);
					precasetier.openprecasetier(p, 4);
				}
				if (p.getItemInHand().getItemMeta().getDisplayName() != null && p.getItemInHand().getItemMeta().getDisplayName().equals(casename5)) {
					e.setCancelled(true);
					p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 1, 1);
					precasetier.openprecasetier(p, 5);
				}
			}
		}
	}

		/*
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.CHEST) {
			World w = p.getWorld();

			TODO: sprawdzić czy otwieranie są skrzynki na spawnie
					world guard coś takiego

			if (p.getItemInHand().getItemMeta().getDisplayName().equals(keyname1)) {
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 1, 1);
				precasetier.openprecasetier(p, 1);
			}
			if (p.getItemInHand().getItemMeta().getDisplayName().equals(keyname2)) {
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 1, 1);
				precasetier.openprecasetier(p, 2);
			}
			if (p.getItemInHand().getItemMeta().getDisplayName().equals(keyname3)) {
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 1, 1);
				precasetier.openprecasetier(p, 3);
			}
			if (p.getItemInHand().getItemMeta().getDisplayName().equals(keyname4)) {
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 1, 1);
				precasetier.openprecasetier(p, 4);
			}
			if (p.getItemInHand().getItemMeta().getDisplayName().equals(keyname5)) {
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 1, 1);
				precasetier.openprecasetier(p, 5);
			}
			if (p.getItemInHand() == null) {
				p.sendMessage(plugin.getConfig().getString("WARNING_DO_NOT_HAVE_KEYS").replace("&", "§"));
				p.closeInventory();
			}



		*/

	/*
				for (ProtectedRegion region : wg.getRegionManager(w).getApplicableRegions(e.getClickedBlock().getLocation())) {
				if (region.getId() != null) {
					if (RegionUtils.getAt(e.getPlayer().getLocation()) == null) {
						if (region.getId().equalsIgnoreCase("spawn")) {
	 */
	@EventHandler
	public void openchestinv(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		String keyname1 = plugin.getConfig().getString("Names.Tier 1 key.Name").replace("&", "§");
		String keyname2 = plugin.getConfig().getString("Names.Tier 2 key.Name").replace("&", "§");
		String keyname3 = plugin.getConfig().getString("Names.Tier 3 key.Name").replace("&", "§");
		String keyname4 = plugin.getConfig().getString("Names.Tier 4 key.Name").replace("&", "§");
		String keyname5 = plugin.getConfig().getString("Names.Tier 5 key.Name").replace("&", "§");
		String casename1 = plugin.getConfig().getString("Names.Tier 1 Case.Name").replace("&", "§");
		String casename2 = plugin.getConfig().getString("Names.Tier 2 Case.Name").replace("&", "§");
		String casename3 = plugin.getConfig().getString("Names.Tier 3 Case.Name").replace("&", "§");
		String casename4 = plugin.getConfig().getString("Names.Tier 4 Case.Name").replace("&", "§");
		String casename5 = plugin.getConfig().getString("Names.Tier 5 Case.Name").replace("&", "§");
		if (e.getView().getTitle().equals(plugin.getConfig().getString("Names.Tier 1 Case.Name").replace("&", "§") + " - preview")) {
				e.setCancelled(true);
				if(e.getCurrentItem() != null) {
					if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("OPEN_CASE").replace("&", "§"))) {
						if (p.getItemInHand().getItemMeta().getDisplayName().equals(casename1)) {
							if (p.getInventory().containsAtLeast(CaseAPI.newItem(Material.TRIPWIRE_HOOK, plugin.getConfig().getString("Names.Tier 1 key.Name").replace("&", "§")), 1)) {
								for (int i = 0; i < 36; i++) {
									if (p.getInventory().getItem(i) != null && p.getInventory().getItem(i).getItemMeta().getDisplayName() != null && p.getInventory().getItem(i).getItemMeta().getDisplayName().equals(keyname1)) {
										if (p.getInventory().getItem(i).getAmount() > 1) {
											p.getInventory().setItem(i, CaseAPI.newItem(p.getInventory().getItem(i).getType(), p.getInventory().getItem(i).getAmount() - 1, p.getInventory().getItem(i).getItemMeta().getDisplayName()));
										} else if (p.getInventory().getItem(i).getAmount() == 1) {
											ItemStack is = new ItemStack(Material.AIR);
											p.getInventory().setItem(i, is);
										}
										break;
									}
								}
								p.setItemInHand(CaseAPI.newItem(p.getItemInHand().getType(), p.getItemInHand().getAmount() - 1, p.getItemInHand().getItemMeta().getDisplayName()));
								CaseAPI.openCase(p, 1);
							} else {
								p.playSound(p.getLocation(), Sound.BLOCK_CHEST_CLOSE, 1, 1);
								p.sendMessage(plugin.getConfig().getString("WARNING_DO_NOT_HAVE_KEYS").replace("&", "§"));
								p.closeInventory();
							}
						}
					}
					else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("CLOSE_CASE").replace("&", "§"))) {
						p.closeInventory();
						p.playSound(p.getLocation(), Sound.BLOCK_CHEST_CLOSE, 1, 1);
					}
				}
		}
		if (e.getView().getTitle().equals(plugin.getConfig().getString("Names.Tier 2 Case.Name").replace("&", "§") + " - preview")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("OPEN_CASE").replace("&", "§"))) {
					if (p.getItemInHand().getItemMeta().getDisplayName().equals(casename2)) {
						if (p.getInventory().containsAtLeast(CaseAPI.newItem(Material.TRIPWIRE_HOOK, 1, plugin.getConfig().getString("Names.Tier 2 key.Name").replace("&", "§")), 1)) {
							for (int i = 0; i < 36; i++) {
								if (p.getInventory().getItem(i) != null && p.getInventory().getItem(i).getItemMeta().getDisplayName() != null && p.getInventory().getItem(i).getItemMeta().getDisplayName().equals(keyname2)) {
									if (p.getInventory().getItem(i).getAmount() > 1) {
										p.getInventory().setItem(i, CaseAPI.newItem(p.getInventory().getItem(i).getType(), p.getInventory().getItem(i).getAmount() - 1, p.getInventory().getItem(i).getItemMeta().getDisplayName()));
									} else if (p.getInventory().getItem(i).getAmount() == 1) {
										ItemStack is = new ItemStack(Material.AIR);
										p.getInventory().setItem(i, is);
									}
									break;
								}
							}
							p.setItemInHand(CaseAPI.newItem(p.getItemInHand().getType(), p.getItemInHand().getAmount() - 1, p.getItemInHand().getItemMeta().getDisplayName()));
							CaseAPI.openCase(p, 2);
						} else {
							p.playSound(p.getLocation(), Sound.BLOCK_CHEST_CLOSE, 1, 1);
							p.sendMessage(plugin.getConfig().getString("WARNING_DO_NOT_HAVE_KEYS").replace("&", "§"));
							p.closeInventory();
						}
					}
				}
				else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("CLOSE_CASE").replace("&", "§"))) {
					p.closeInventory();
					p.playSound(p.getLocation(), Sound.BLOCK_CHEST_CLOSE, 1, 1);
				}
			}
		}
		if (e.getView().getTitle().equals(plugin.getConfig().getString("Names.Tier 3 Case.Name").replace("&", "§") + " - preview")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("OPEN_CASE").replace("&", "§"))) {
					if (p.getItemInHand().getItemMeta().getDisplayName().equals(casename3)) {
						if (p.getInventory().containsAtLeast(CaseAPI.newItem(Material.TRIPWIRE_HOOK, 1, plugin.getConfig().getString("Names.Tier 3 key.Name").replace("&", "§")), 1)) {
							for (int i = 0; i < 36; i++) {
								if (p.getInventory().getItem(i) != null && p.getInventory().getItem(i).getItemMeta().getDisplayName() != null && p.getInventory().getItem(i).getItemMeta().getDisplayName().equals(keyname3)) {
									if (p.getInventory().getItem(i).getAmount() > 1) {
										p.getInventory().setItem(i, CaseAPI.newItem(p.getInventory().getItem(i).getType(), p.getInventory().getItem(i).getAmount() - 1, p.getInventory().getItem(i).getItemMeta().getDisplayName()));
									} else if (p.getInventory().getItem(i).getAmount() == 1) {
										ItemStack is = new ItemStack(Material.AIR);
										p.getInventory().setItem(i, is);
									}
									break;
								}
							}
							p.setItemInHand(CaseAPI.newItem(p.getItemInHand().getType(), p.getItemInHand().getAmount() - 1, p.getItemInHand().getItemMeta().getDisplayName()));
							CaseAPI.openCase(p, 3);
						} else {
							p.playSound(p.getLocation(), Sound.BLOCK_CHEST_CLOSE, 1, 1);
							p.sendMessage(plugin.getConfig().getString("WARNING_DO_NOT_HAVE_KEYS").replace("&", "§"));
							p.closeInventory();
						}
					}
				}
				else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("CLOSE_CASE").replace("&", "§"))) {
					p.closeInventory();
					p.playSound(p.getLocation(), Sound.BLOCK_CHEST_CLOSE, 1, 1);
				}
			}
		}
		if (e.getView().getTitle().equals(plugin.getConfig().getString("Names.Tier 4 Case.Name").replace("&", "§") + " - preview")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("OPEN_CASE").replace("&", "§"))) {
					if (p.getItemInHand().getItemMeta().getDisplayName().equals(casename4)) {
						if (p.getInventory().containsAtLeast(CaseAPI.newItem(Material.TRIPWIRE_HOOK, 1, plugin.getConfig().getString("Names.Tier 4 key.Name").replace("&", "§")), 1)) {
							for (int i = 0; i < 36; i++) {
								if (p.getInventory().getItem(i) != null && p.getInventory().getItem(i).getItemMeta().getDisplayName() != null && p.getInventory().getItem(i).getItemMeta().getDisplayName().equals(keyname4)) {
									if (p.getInventory().getItem(i).getAmount() > 1) {
										p.getInventory().setItem(i, CaseAPI.newItem(p.getInventory().getItem(i).getType(), p.getInventory().getItem(i).getAmount() - 1, p.getInventory().getItem(i).getItemMeta().getDisplayName()));
									} else if (p.getInventory().getItem(i).getAmount() == 1) {
										ItemStack is = new ItemStack(Material.AIR);
										p.getInventory().setItem(i, is);
									}
									break;
								}
							}
							p.setItemInHand(CaseAPI.newItem(p.getItemInHand().getType(), p.getItemInHand().getAmount() - 1, p.getItemInHand().getItemMeta().getDisplayName()));
							CaseAPI.openCase(p, 4);
						} else {
							p.playSound(p.getLocation(), Sound.BLOCK_CHEST_CLOSE, 1, 1);
							p.sendMessage(plugin.getConfig().getString("WARNING_DO_NOT_HAVE_KEYS").replace("&", "§"));
							p.closeInventory();
						}
					}
				}
				else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("CLOSE_CASE").replace("&", "§"))) {
					p.closeInventory();
					p.playSound(p.getLocation(), Sound.BLOCK_CHEST_CLOSE, 1, 1);
				}
			}
		}
		if (e.getView().getTitle().equals(plugin.getConfig().getString("Names.Tier 5 Case.Name").replace("&", "§") + " - preview")) {
			e.setCancelled(true);
			if (e.getCurrentItem() != null) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("OPEN_CASE").replace("&", "§"))) {
					if (p.getItemInHand().getItemMeta().getDisplayName().equals(casename5)) {
						if (p.getInventory().containsAtLeast(CaseAPI.newItem(Material.TRIPWIRE_HOOK, 1, plugin.getConfig().getString("Names.Tier 5 key.Name").replace("&", "§")), 1)) {
							for (int i = 0; i < 36; i++) {
								if (p.getInventory().getItem(i) != null && p.getInventory().getItem(i).getItemMeta().getDisplayName() != null && p.getInventory().getItem(i).getItemMeta().getDisplayName().equals(keyname5)) {
									if (p.getInventory().getItem(i).getAmount() > 1) {
										p.getInventory().setItem(i, CaseAPI.newItem(p.getInventory().getItem(i).getType(), p.getInventory().getItem(i).getAmount() - 1, p.getInventory().getItem(i).getItemMeta().getDisplayName()));
									} else if (p.getInventory().getItem(i).getAmount() == 1) {
										ItemStack is = new ItemStack(Material.AIR);
										p.getInventory().setItem(i, is);
									}
									break;
								}
							}
							p.setItemInHand(CaseAPI.newItem(p.getItemInHand().getType(), p.getItemInHand().getAmount() - 1, p.getItemInHand().getItemMeta().getDisplayName()));
							CaseAPI.openCase(p, 5);
						} else {
							p.playSound(p.getLocation(), Sound.BLOCK_CHEST_CLOSE, 1, 1);
							p.sendMessage(plugin.getConfig().getString("WARNING_DO_NOT_HAVE_KEYS").replace("&", "§"));
							p.closeInventory();
						}
					}
				}
				else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("CLOSE_CASE").replace("&", "§"))) {
					p.closeInventory();
					p.playSound(p.getLocation(), Sound.BLOCK_CHEST_CLOSE, 1, 1);
				}
			}
		}

	}

}

