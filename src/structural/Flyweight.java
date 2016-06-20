package structural;

import java.awt.Color;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.WeakHashMap;

enum FontEffect {
	BOLD, ITALIC, SUPERSCRIPT, SUBSCRIPT, STRIKETHROUGH
}

/**
 * The examples illustrate the flyweight pattern used to reduce memory by
 * loading only the data necessary to perform some immediate task from a large
 * Font object into a much smaller (flyweight) object.
 */
public final class Flyweight {
	/**
	 * A weak hash map will drop unused references to Flyweight. Values have to
	 * be wrapped in WeakReferences, because value objects in weak hash map are
	 * held by strong references.
	 */
	private static final WeakHashMap<Flyweight, WeakReference<Flyweight>> FLY_WEIGHT_DATA = new WeakHashMap<Flyweight, WeakReference<Flyweight>>();
	private final int pointSize;
	private final String fontFace;
	private final Color color;
	private final Set<FontEffect> effects;

	private Flyweight(int pointSize, String fontFace, Color color, EnumSet<FontEffect> effects) {
		this.pointSize = pointSize;
		this.fontFace = fontFace;
		this.color = color;
		this.effects = Collections.unmodifiableSet(effects);
	}

	public static Flyweight create(int pointSize, String fontFace, Color color, FontEffect... effects) {
		EnumSet<FontEffect> effectsSet = EnumSet.noneOf(FontEffect.class);
		for (FontEffect fontEffect : effects) {
			effectsSet.add(fontEffect);
		}
		// We are unconcerned with object creation cost, we are reducing overall
		// memory consumption
		Flyweight data = new Flyweight(pointSize, fontFace, color, effectsSet);
		if (!FLY_WEIGHT_DATA.containsKey(data)) {
			FLY_WEIGHT_DATA.put(data, new WeakReference<Flyweight>(data));
		}
		// return the single immutable copy with the given values
		return FLY_WEIGHT_DATA.get(data).get();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Flyweight) {
			if (obj == this) {
				return true;
			}
			Flyweight other = (Flyweight) obj;
			return other.pointSize == pointSize && other.fontFace.equals(fontFace) && other.color.equals(color)
					&& other.effects.equals(effects);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (pointSize * 37 + effects.hashCode() * 13) * fontFace.hashCode();
	}

	// Getters for the font data, but no setters. Flyweight is immutable.
}