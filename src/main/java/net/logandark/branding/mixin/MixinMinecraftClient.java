package net.logandark.branding.mixin;

import net.minecraft.SharedConstants;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {
	@Redirect(
		method = "<init>",
		at = @At(
			value = "FIELD",
			target = "Lnet/minecraft/client/RunArgs$Game;version:Ljava/lang/String;"
		)
	)
	private String redirectVersion(RunArgs.Game game) {
		return SharedConstants.getGameVersion().getName();
	}

	@Redirect(
		method = "<init>",
		at = @At(
			value = "FIELD",
			target = "Lnet/minecraft/client/RunArgs$Game;versionType:Ljava/lang/String;"
		)
	)
	private String redirectVersionType(RunArgs.Game game) {
		String versionType = game.versionType;

		if (versionType.endsWith("Fabric")) {
			if (versionType.endsWith("/Fabric")) {
				return versionType.substring(0, versionType.length() - 7);
			}

			return "release";
		}

		return versionType;
	}
}
