package ethos.model.players.packets.npcoptions;

import java.util.Objects;

import ethos.Config;
import ethos.Server;
import ethos.model.content.PotionMixing;
import ethos.model.content.achievement_diary.desert.DesertDiaryEntry;
import ethos.model.content.achievement_diary.kandarin.KandarinDiaryEntry;
import ethos.model.holiday.halloween.HalloweenRandomOrder;
import ethos.model.npcs.NPC;
import ethos.model.npcs.NPCHandler;
import ethos.model.npcs.pets.PetHandler;
import ethos.model.npcs.pets.Probita;
import ethos.model.players.Boundary;
import ethos.model.players.Player;
import ethos.model.players.skills.Fishing;
import ethos.model.players.skills.agility.AgilityHandler;
import ethos.model.players.skills.crafting.Tanning;
import ethos.model.players.skills.hunter.impling.Impling;
import ethos.model.players.skills.mining.Mineral;
import ethos.model.players.skills.thieving.Thieving.Pickpocket;
import ethos.runehub.action.click.npc.FirstClickNpcListener;
import ethos.runehub.entity.player.action.FirstClickNPCActionFactory;
import ethos.util.Location3D;
import ethos.util.Misc;

/*
 * @author Matt
 * Handles all first options on non playable characters.
 */

public class NpcOptionOne {
	  // Define an array of phrases for the NPC
    private static final String[] phrases = {"Beep-Boop", "Whirrrrrr", "*Whistle*", "-- .- -.-- / - .... . / ..-. --- .-. -.-. . / -... . / .-- .. - .... / -.-- --- ..-"};
    // Define a variable to keep track of the current index
    private static int currentIndex = 0;

    // Method to handle click event
    public static void handleClick() {
        // Your click handling code
        // For example:
        int clickEvent = 7200; // Example click event

        switch (clickEvent) {
           
            // Other cases...
            default:
                // Handle other cases if needed
        }
    }
	public static void handleOption(Player player, int npcType) {
		if (Server.getMultiplayerSessionListener().inAnySession(player)) {
			return;
		}
		player.clickNpcType = 0;
		player.rememberNpcIndex = player.npcClickIndex;
		player.npcClickIndex = 0;

		/*
		 * if(Fishing.fishingNPC(c, npcType)) { Fishing.fishingNPC(c, 1, npcType);
		 * return; }
		 */
		if (PetHandler.isPet(npcType)) {
			if (Objects.equals(PetHandler.getOptionForNpcId(npcType), "first")) {
				if (PetHandler.pickupPet(player, npcType, true))
					return;
			}
		}
		if (Server.getHolidayController().clickNpc(player, 1, npcType)) {
			return;
		}
		switch (npcType) {
		 case 7200:
             NPC npc = NPCHandler.getNpc(7200);
             // Get the current phrase using the currentIndex
             String currentPhrase = phrases[currentIndex];
             // Force the NPC to chat with the current phrase
             npc.forceChat(currentPhrase);
             // Increment the index for the next click
             currentIndex = (currentIndex + 1) % phrases.length; // Wrap around to 0 when reaching the end
             break;
		case 5419:
			player.getDH().sendDialogues(15000, 5419);
			break;

		case 5736:
			player.getShops().openShop(124);
			break;
		
		case 5527:
			player.getDH().sendDialogues(6500, 10);
			break;
		
		case 6651:
			player.getDH().sendDialogues(9000, 6651);
			break;
			
		case 5558:
			player.getDH().sendDialogues(9006, 5558);
			break;
			
		case 3099:
			if (Misc.random(7) == 0) {
			player.getDH().sendDialogues(9015, 3099);
			} else if (Misc.random(7) == 0) {
				player.getDH().sendDialogues(9020, 3099);
			} else if (Misc.random(7) == 0) {
				player.getDH().sendDialogues(9025, 3099);
			} else if (Misc.random(7) == 0) {
				player.getDH().sendDialogues(9029, 3099);
			} else {
				player.getDH().sendDialogues(9033, 3099);
			}
			break;
			
		case 6637:
			player.getDH().sendDialogues(9035, 6637);
			break;
			
		case 6638:
			player.getDH().sendDialogues(9050, 6638);
			break;
			
		case 5907:
			player.getDH().sendDialogues(9051, 5907);
			break;
			
		case 6627:
			player.getDH().sendDialogues(9055, 6627);
			break;
		
		case 2986: //Necromancy NPC
			if (Boundary.isIn(player, Boundary.NECRO)) {
				if (player.nlevel == 1) {
					player.getPA().showInterface(8000);
					player.getPA().sendFrame126(""+player.nlevel+"/10", 8007);
					player.getPA().sendFrame126(""+player.nxp+"/50", 8009);
				}
				if (player.nlevel == 2) {
					player.getPA().showInterface(8000);
					player.getPA().sendFrame126(""+player.nlevel+"/10", 8007);
					player.getPA().sendFrame126(""+player.nxp+"/150", 8009);
				}
				if (player.nlevel == 3) {
					player.getPA().showInterface(8000);
					player.getPA().sendFrame126(""+player.nlevel+"/10", 8007);
					player.getPA().sendFrame126(""+player.nxp+"/300", 8009);
				}
				if (player.nlevel == 4) {
					player.getPA().showInterface(8000);
					player.getPA().sendFrame126(""+player.nlevel+"/10", 8007);
					player.getPA().sendFrame126(""+player.nxp+"/550", 8009);
				}
				if (player.nlevel == 5) {
					player.getPA().showInterface(8000);
					player.getPA().sendFrame126(""+player.nlevel+"/10", 8007);
					player.getPA().sendFrame126(""+player.nxp+"/800", 8009);
				}
				if (player.nlevel == 6) {
					player.getPA().showInterface(8000);
					player.getPA().sendFrame126(""+player.nlevel+"/10", 8007);
					player.getPA().sendFrame126(""+player.nxp+"/1200", 8009);

				}
				if (player.nlevel == 7) {
					player.getPA().showInterface(8000);
					player.getPA().sendFrame126(""+player.nlevel+"/10", 8007);
					player.getPA().sendFrame126(""+player.nxp+"/2000", 8009);

				}
				if (player.nlevel == 8) {
					player.getPA().showInterface(8000);
					player.getPA().sendFrame126(""+player.nlevel+"/10", 8007);
					player.getPA().sendFrame126(""+player.nxp+"/3500", 8009);

				}
				if (player.nlevel == 9) {
					player.getPA().showInterface(8000);
					player.getPA().sendFrame126(""+player.nlevel+"/10", 8007);
					player.getPA().sendFrame126(""+player.nxp+"/6200", 8009);

				}
				if (player.nlevel == 10) {
					player.getPA().showInterface(8000);
					player.getPA().sendFrame126(""+player.nlevel+"/10", 8007);
					player.getPA().sendFrame126(""+player.nxp+"/7000", 8009);

				}
			}
			break;

		case 1603:
			player.getDH().sendDialogues(150, npcType);
			break;
case 4625:
	player.getShops().openShop(9);
	player.sendMessage("@blu@ Please type ::donate to go to the donation store. 1 Trading Stick is 1$. ");
	player.sendMessage("@blu@You can also donate RSGP to (pepsiplaya) only!");
	player.sendMessage("@blu@Anything above 10$ at once will have a chance to receive a Ultra Mystery Box!");
	break;
		case 7690:
			player.createInfernoInstance();
			player.getInfernoMinigame().create(1);
			player.getInfernoMinigame().getPlayer();
			break;
			case 4407:
				player.getShops().openShop(119);
				break;
				
			case 2110:
				player.getDH().sendDialogues(5000, npcType);
				break;

		case 5314:
			player.getPA().showInterface(51000);
			player.getTeleport().loadMonsterTab();
			//player.getTeleport().selection(player, 0);
			break;

		case 1143:
			player.getShops().openShop(83);
			break;

		case 1909:
			player.getDH().sendDialogues(900, 1909);
			break;
		case 2989:
			player.getDH().sendDialogues(1427, 2989);
			break;
		case 3306:
			player.getDH().sendDialogues(1577, -1);
			break;
		case 7520:
			player.getDH().sendDialogues(850, 7520);
			break;
		/**
		 * Doomsayer
		 */
		case 6773:
			if (!player.pkDistrict) {
				player.sendMessage("You cannot do this right now.");
				return;
			}
			player.getDH().sendDialogues(800, 6773);
			break;
		// Zeah Throw Aways
		case 2200:
			player.getDH().sendDialogues(55873, 2200);
			break;
		case 3189:
			player.getDH().sendDialogues(11929, 3189);
			break;
		case 5998:
			if (player.amDonated <= 1) {
				player.getDH().sendDialogues(5998, 5998);
			} else {
				player.getDH().sendDialogues(5999, 5998);
			}
			break;
		case 4062:
			player.getDH().sendDialogues(55875, 4062);
			break;
		case 4321:
			player.getDH().sendDialogues(145, 4321);
			break;
		case 7041:
			player.getDH().sendDialogues(500, 7041);
			break;
		case 6877:
			player.getDH().sendDialogues(55877, 6877);
			break;
		case 4409:
			player.getDH().sendDialogues(55876, 4409);
			break;
		case 6982:
			player.getDH().sendDialogues(55868, 6982);
			break;
		case 6947:
		case 6948:
		case 6949:
			player.getDH().sendDialogues(55872, 6947);
			break;
		case 6998:
			player.getDH().sendDialogues(55871, 6998);
			break;
		case 7001:
			player.getDH().sendDialogues(55869, 7001);
			break;
		case 6999:
			player.getDH().sendDialogues(55870, 6999);
			break;
		case 6904:
			player.getDH().sendDialogues(55864, 6904);
			break;
		case 6906:
			player.getDH().sendDialogues(55865, 6904);
			break;
		case 6908:
			player.getDH().sendDialogues(55866, 6904);
			break;
		case 6910:
			player.getDH().sendDialogues(55867, 6904);
			break;
		// End Zeah Throw Aways
		case 1503:
			player.getDH().sendDialogues(88393, 1503);
			break;
		case 1504:
			player.getDH().sendDialogues(88394, 1504);
			break;

		case 6774:
			player.getDH().sendDialogues(800, 6773);
			break;

		case 7440:
			HalloweenRandomOrder.checkOrder(player);
			break;
		case 822:
			if (player.getDiaryManager().getWildernessDiary().hasDoneEasy()) {
				player.getDH().sendDialogues(702, 822);
			} else {
				if (player.getItems().playerHasItem(11286) && player.getItems().playerHasItem(1540)
						&& player.getItems().playerHasItem(995, 5_000_000)) {
					player.getItems().deleteItem(11286, 1);
					player.getItems().deleteItem(1540, 1);
					player.getItems().deleteItem(995, 500_000);
					player.getItems().addItem(11283, 1);
					player.votePoints -= 5;
					player.refreshQuestTab(2);
					player.getDH().sendItemStatement("Oziach successfully bound your dragonfire shield.", 11283);
				} else {
					player.getDH().sendNpcChat("Come back with a shield, visage and 5M Gold!");
				}
			}
			break;
		case 306:
			player.getDH().sendDialogues(710, 306);
			break;

		case 7303:
			player.sendMessage("I will trade a full set of clue scrolls with a master one.");
			break;

		case 2914:
			player.getDH().sendNpcChat2("Use a Zamorakian Spear on me to turn", "it into a Hasta! Or Vice Versa.", 2914,
					"Otto Godblessed");
			break;

		case 1635:
		case 1636:
		case 1637:
		case 1638:
		case 1639:
		case 1640:
		case 1641:
		case 1642:
		case 1643:
		case 1654:
		case 7302:
			Impling.catchImpling(player, npcType, player.rememberNpcIndex);
			break;

		case 17: // Rug merchant - Pollnivneach
			if (!player.getDiaryManager().getDesertDiary().hasCompleted("MEDIUM")) {
				player.getDH().sendNpcChat1(
						"You must have completed all medium diaries here in the desert \\n to use this location.", 17,
						"Rug Merchant");
				return;
			}
			player.getDiaryManager().getDesertDiary().progress(DesertDiaryEntry.TRAVEL_POLLNIVNEACH);
			player.startAnimation(2262);
			AgilityHandler.delayFade(player, "NONE", 3351, 3003, 0, "You step on the carpet and take off...",
					"at last you end up in pollnivneach.", 3);
			break;
		case 276: //bonus drops
			if (Config.BONUS_XP_WOGW = true) {
				player.getDH().sendNpcChat1(
						"Well of Goodwill is currently @red@active@bla@! \\n It is granting 1 hour of @red@Double XP@bla@!",
						276, "Os-Revolution Crier");
			}  if (Config.BONUS_PC_WOGW = true) {
				player.getDH().sendNpcChat1(
						"Well of Goodwill is currently @red@active@bla@! \\n It is granting 1 hour of @red@+ 10 Pc Points@bla@!",
						276, "Os-Revolution Crier");
			}  if (Config.DOUBLE_DROPS = true) {
				player.getDH().sendNpcChat1(
						"Well of Goodwill is currently @red@active@bla@! \\n It is granting 1 hour of @red@Double Drops@bla@!",
						276, "Os-Revolution Crier");
			} else {
				player.getDH().sendNpcChat1("Well of Goodwill is currently @red@inactive@bla@!", 276, "Os-Revolution Crier");
			}
			break;
		case 5520:
			player.getDiaryManager().getDesertDiary().claimReward();
			break;
		case 5519:
			player.getDiaryManager().getArdougneDiary().claimReward();
			break;
		case 5790:
			player.getDiaryManager().getKaramjaDiary().claimReward();
			break;
		case 5525:
			player.getDiaryManager().getVarrockDiary().claimReward();
			break;
		case 5523:
			player.getDiaryManager().getLumbridgeDraynorDiary().claimReward();
			break;
		case 5524:
			player.getDiaryManager().getFaladorDiary().claimReward();
			break;
		case 5521:
			player.getDiaryManager().getMorytaniaDiary().claimReward();
			break;
		case 5514:
			player.getDiaryManager().getWildernessDiary().claimReward();
			break;
		case 5517:
			player.getDiaryManager().getKandarinDiary().claimReward();
			break;
		case 5526:
			player.getDiaryManager().getFremennikDiary().claimReward();
			break;
		case 5518:
			player.getDiaryManager().getWesternDiary().claimReward();
			break;

		case 3936:
			player.getDH().sendNpcChat1("Right click on me and i will take you on-board.", 3936, "Sailor");
			break;

		case 1031:
			if (player.getItems().playerHasItem(995, 30)) {
				player.getItems().deleteItem(995, 30);
				player.getItems().addItem(36, 1);
				player.getDiaryManager().getKandarinDiary().progress(KandarinDiaryEntry.BUY_CANDLE);
			} else {
				player.sendMessage("You need 30 coins to purchase a candle.");
				return;
			}
			break;

		case 6586:
			player.getDH().sendNpcChat1("No shirt, Sherlock", 6586, "Sherlock");
			player.getDiaryManager().getKandarinDiary().progress(KandarinDiaryEntry.SHERLOCK);
			break;

		case 5036:
			if (player.getItems().playerHasItem(225) || player.getItems().playerHasItem(223)) {
				player.sendMessage("The Apothecary takes your ingredients and creates a strength potion.");
				player.getItems().deleteItem(225, 1);
				player.getItems().deleteItem(223, 1);
				player.getItems().addItem(115, 1);
				//player.getDiaryManager().getVarrockDiary().progress(VarrockDiaryEntry.APOTHECARY_STRENGTH);
			} else {
				player.sendMessage("You must have limpwurt root and red spiders' eggs to do this.");
				return;
			}
			break;

		case 5906:
			Probita.hasInvalidPet(player);
			break;

		case 3500:
			player.getDH().sendDialogues(64, npcType);
			break;

		case 5870:
			if (player.getCerberusLostItems().size() > 0) {
				player.getDH().sendDialogues(640, 5870);
				return;
			}
			player.getDH().sendDialogues(105, npcType);
			break;

		case 7283:
			if (player.getSkotizoLostItems().size() > 0) {
				player.getDH().sendDialogues(640, 7283);
				return;
			}
			player.getDH().sendDialogues(105, npcType);
			break;

		case 6481: // Max
			if (!player.maxRequirements(player)) {
				player.sendMessage("Mac does not even bother speaking to you.");
				return;
			}
			player.getDH().sendDialogues(85, npcType);
			break;
		case 3307: // Combat instructor
			player.getDH().sendDialogues(1390, npcType);
			break;

		case 5513: // Elite void knight
			player.getDH().sendDialogues(79, npcType);
			break;

		case 6071: // Achievement cape
			player.getAchievements().claimCape();
			break;
			
		//New Home Npc's
			
		case 7924: // Regional Director
			player.getDH().sendDialogues(10002, npcType);
			break;
		case 7330: // CEO
			player.getDH().sendDialogues(10001, npcType);
			break;
			
		//End	
			
		case 394:
			player.getDH().sendDialogues(669, npcType);
			break;
		case 311:
			player.getDH().sendDialogues(650, npcType);
			break;

		// Noting Npc At Skill Area
		case 905:
			player.talkingNpc = 905;
			player.getDH().sendNpcChat("Hello there, I can note your resources.",
					"I charge @red@25%@bla@ of the yield, this @red@does not apply to donators@bla@.",
					"Use any resource item obtained in this area on me.");
			player.nextChat = -1;
			break;

		case 2040:
			player.getDH().sendDialogues(637, npcType);
			break;
		case 2184:
			player.getShops().openShop(29);
			break;

		case 6866:
			player.getShops().openShop(82);
			player.sendMessage("You currently have @red@" + player.getShayPoints() + " @bla@Assault Points!");
			break;

		case 6601:
			NPC golem = NPCHandler.npcs[player.rememberNpcIndex];
			if (golem != null) {
				player.getMining().mine(golem, Mineral.RUNE,
						new Location3D(golem.getX(), golem.getY(), golem.heightLevel));
			}
			break;
		case 1850:
			player.getShops().openShop(112);
			break;
		case 2580:
			player.getDH().sendDialogues(629, npcType);
			break;
		case 3257:
			if(player.getMode().isIronman() || player.getMode().isUltimateIronman()){
				player.getThieving().steal(Pickpocket.FARMER, NPCHandler.npcs[player.rememberNpcIndex]);
			}else{
				player.getShops().openShop(16);
			}
			break;
		case 3894:
			player.getDH().sendDialogues(628, npcType);
			break;
		case 3220:
			player.getShops().openShop(25);
			break;
			case 6875:
				player.specRestore = 120;
				player.specAmount = 10.0;
				player.setRunEnergy(100);
				player.getItems().addSpecialBar(player.playerEquipment[player.playerWeapon]);
				player.playerLevel[5] = player.getPA().getLevelForXP(player.playerXP[5]);
				player.getHealth().removeAllStatuses();
				player.getHealth().reset();
				player.getPA().refreshSkill(5);
				player.sendMessage("Restored your HP, Prayer, Run Energy, and Spec");
				player.nextChat =  -1;
				break;
			case 732:
			player.getShops().openShop(16);
			break;
		case 3219:
			player.getShops().openShop(113);
			break;
		case 2949:
			player.getPestControlRewards().showInterface();
			break;
		case 2461:
			player.getWarriorsGuild().handleDoor();
			break;
		case 7663:
			player.getDH().sendDialogues(3299, npcType);
			break;
//		case 402:// slayer
//			if(player.combatLevel<20){
//				player.getDH().sendNpcChat2("Do not waste my time peasent.","You need a Combat level of 20.",402,"Mazchna");
//				return;
//			}
//			player.getDH().sendDialogues(3300, npcType);
//			break;
//		case 401:
//			player.getDH().sendDialogues(3300, npcType);
//			break;
//		case 405:
//			if(player.combatLevel<100){
//				player.getDH().sendNpcChat2("Do not waste my time peasent.","You need a Combat level of at least 100.",402,"Duradel");
//				return;
//			}
//			if (player.playerLevel[18] < 50) {
//				player.getDH().sendNpcChat1("You must have a slayer level of at least 50 weakling.", 490, "Duradel");
//				return;
//			}
//			player.getDH().sendDialogues(3300, npcType);
//			break;
//		case 6797: // Nieve
//			if (player.playerLevel[18] < 90) {
//				player.getDH().sendNpcChat1("You must have a slayer level of at least 90 weakling.", 490, "Nieve");
//				return;
//			} else {
//				player.getDH().sendDialogues(3300, npcType);
//			}
//			break;
		case 315:
			player.getDH().sendDialogues(550, npcType);
			break;

		case 1308:
			player.getDH().sendDialogues(538, npcType);
			break;
		case 6771:
			player.getShops().openShop(78);
			player.sendMessage("You currently have " + player.getAchievements().getPoints() + " Achievement points.");
			break;
		case 7456:
			player.getDH().sendDialogues(619, npcType);
			break;
		case 4306:
			player.getShops().openSkillCape();
			break;
		case 3341:
			player.getDH().sendDialogues(2603, npcType);
			break;
		case 5919: //agility
			player.getDH().sendDialogues(14400, npcType);
			break;
		case 6599:
			player.getShops().openShop(12);
			break;
		case 2578: //rings
			player.getDH().sendDialogues(2401, npcType);
			break;
		case 3789:
			player.getShops().openShop(75);
			break;
		// FISHING
		case 3913: // NET + BAIT
			Fishing.attemptdata(player, 1);
			break;
		case 3317:
			Fishing.attemptdata(player, 14);
			break;
		case 4712:
			Fishing.attemptdata(player, 15);
			break;
//		case 1524:
////			Fishing.attemptdata(player, 11);
//			NPC spot = NPCHandler.npcs[player.rememberNpcIndex];
//			player.getSkillController().getFishing().train(
//					new FishingSkillAction(
//							player,
//							10,
//							new FishingNodeContext(
//									1,
//									spot.getX(),
//									spot.getY(),
//									spot.heightLevel
//							),
//							2,
//							1524
//					)
//			);
//			break;
		case 3417: // TROUT
			Fishing.attemptdata(player, 4);
			break;
		case 3657:
			Fishing.attemptdata(player, 8);
			break;
		case 635:
			Fishing.attemptdata(player, 13); // DARK CRAB FISHING
			break;
		case 6825: // Anglerfish
			Fishing.attemptdata(player, 16);
			break;
		case 1520: // LURE
		case 310:
		case 314:
		case 317:
		case 318:
		case 328:
		case 331:
			Fishing.attemptdata(player, 9);
			break;

		case 944:
			player.getDH().sendOption5("Hill Giants", "Hellhounds", "Lesser Demons", "Chaos Dwarf", "-- Next Page --");
			player.teleAction = 7;
			break;

		case 559:
			player.getShops().openShop(16);
			break;

		case 2913:
			player.getShops().openShop(22);
			break;
		case 403:
			player.getDH().sendDialogues(2300, npcType);
			break;
		case 1599:
			break;

		case 953: // Banker
		case 2574: // Banker
		case 166: // Gnome Banker
		case 1702: // Ghost Banker
		case 494: // Banker
		case 495: // Banker
		case 496: // Banker
		case 497: // Banker
		case 498: // Banker
		case 499: // Banker
		case 567: // Banker
		case 766: // Banker
		case 1036: // Banker
		case 1360: // Banker
		case 2163: // Banker
		case 2164: // Banker
		case 2354: // Banker
		case 2355: // Banker
		case 2568: // Banker
		case 2569: // Banker
		case 2570: // Banker
			player.getPA().openUpBank();
			break;
		case 1986:
			player.getDH().sendDialogues(2244, player.npcType);
			break;

		case 5792:
			player.getDH().sendDialogues(4005, player.npcType);
			// player.getShops().openShop(9);
			break;
		case 6747:
			player.getShops().openShop(77);
			break;
		case 3218:// magic supplies
			player.getShops().openShop(6);
			break;
		case 3217:// range supplies
			player.getShops().openShop(4);
			break;
		case 1785:
			player.getShops().openShop(8);
			break;

		case 1860:
			player.getShops().openShop(47);
			break;

		case 519:
			player.getShops().openShop(48);
			break;

		case 548:
			player.getDH().sendDialogues(69, player.npcType);
			break;

		case 2258:
			player.getDH().sendOption2("Teleport me to Runecrafting Abyss.", "I want to stay here, thanks.");
			player.dialogueAction = 2258;
			break;

		case 532:
			player.getShops().openShop(47);
			break;

		case 3216:// melee supplies
			player.getShops().openShop(8);
			break;

		case 507:
			player.getShops().openShop(2);
			break;

		case 5449:
			PotionMixing.decantInventory(player);
			break;

		/*
		 * case 198: c.getShops().openSkillCape(); break;
		 */

		/**
		 * Make over mage.
		 */

		}
		try {
			Server.getEventHandler().submit(FirstClickNpcListener.onClick(player,npcType,player.rememberNpcIndex));
		} catch (NullPointerException e) {
//			e.printStackTrace();
			try {
				player.getAttributes().getActionController().submit(FirstClickNPCActionFactory.getAction(player,player.absX,player.absY,npcType,player.rememberNpcIndex));
			} catch (NullPointerException e1) {
				player.sendMessage("Nothing interesting happens.");
			}
		}
	}

}
