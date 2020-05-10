package takaranoao.lightningmod.mixin;
import net.minecraft.entity.LightningEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LightningEntity.class)
public class MaxinLightningEntity {
    @Shadow
    private int ambientTick;
    @Shadow
    private int remainingActions;
    @Inject(method = "tick",at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        if(ambientTick < -100)ambientTick=0;

        if(this.remainingActions == 0)remainingActions++;
    }
}
