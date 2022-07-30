package net.logandark.branding.mixin;

import net.logandark.branding.Branding;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(MinecraftServer.class)
public abstract class MixinMinecraftServer {
	@Overwrite(remap = false)
	public String getServerModName() {
		return Branding.getServerBrand();
	}
}
