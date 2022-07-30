package net.logandark.branding.mixin;

import net.minecraft.util.ModStatus;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ModStatus.class)
public class MixinModStatus {
	@Redirect(method = "check", at = @At(value = "INVOKE", target = "Ljava/lang/String;equals(Ljava/lang/Object;)Z"))
	private static boolean branding$onCheckEquals(String self, Object other) {
		return true;
	}

	@Redirect(method = "check", at = @At(value = "INVOKE", target = "Ljava/lang/Class;getSigners()[Ljava/lang/Object;"))
	private static Object[] branding$onCheckGetSigners(Class<?> self) {
		return new Class[0];
	}
}
