package game.modal.entities.battlefield;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattlefieldTest {

    @Test
    void getInstance() {
        Battlefield tmp = Battlefield.getInstance(BattlefieldType.SMALL);
        assertSame(tmp, Battlefield.getInstance(BattlefieldType.SMALL));

        Battlefield.reset();

        tmp = Battlefield.getInstance(BattlefieldType.MEDIUM);
        assertSame(tmp, Battlefield.getInstance(BattlefieldType.MEDIUM));

        Battlefield.reset();

        tmp = Battlefield.getInstance(BattlefieldType.BIG);
        assertSame(tmp, Battlefield.getInstance(BattlefieldType.BIG));
    }
}