package net.logandark.branding.mixin;

import net.logandark.branding.Branding;
import net.minecraft.client.ClientBrandRetriever;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ClientBrandRetriever.class)
public abstract class MixinClientBrandRetriever {
	@Overwrite(remap = false)
	public static String getClientModName() {
		return Branding.getClientBrand();
	}
}
