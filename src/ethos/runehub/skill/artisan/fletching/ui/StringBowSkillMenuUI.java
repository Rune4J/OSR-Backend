package ethos.runehub.skill.artisan.fletching.ui;

import ethos.model.players.Player;
import ethos.runehub.skill.artisan.fletching.Fletchable;
import ethos.runehub.skill.artisan.fletching.FletchingSkillMenuUI;
import ethos.runehub.skill.artisan.fletching.action.FletchLogsAction;
import ethos.runehub.skill.artisan.fletching.action.StringBowAction;

public class StringBowSkillMenuUI extends FletchingSkillMenuUI {

    @Override
    protected void create(Fletchable item, int actions) {
        this.close();
        this.getPlayer().getSkillController().getFletching().train(new StringBowAction(this.getPlayer(),item,actions));
    }

    public StringBowSkillMenuUI(Player player, int baseId) {
        super(player, baseId);
    }
}
