# Dynamic Colors in Jetpack Compose 🚀

Dynamic colors enhance the user experience by adapting the UI based on the content, user preferences, or environmental factors. Jetpack Compose provides several ways to implement dynamic colors in your app. This guide will cover the basics of using dynamic colors in Jetpack Compose.



## Table of Contents

- [Introduction](#introduction)
- [Setting Up](#setting-up)
- [Using Dynamic Colors](#using-dynamic-colors)


## Introduction

Dynamic colors in Jetpack Compose allow your app to respond to various conditions and provide a more engaging and visually pleasing experience for users. This guide will walk you through setting up and using dynamic colors effectively.

## Setting Up

Before you start using dynamic colors, ensure you have Jetpack Compose set up in your project. If not, follow the official [Jetpack Compose setup guide](https://developer.android.com/jetpack/compose/setup) to get started.

## Using Dynamic Colors

Color Role                 | Android Attribute            | Light Baseline | Light Dynamic 31-33 | Light Dynamic 34+                   | Dark Baseline | Dark Dynamic 31-33 | Dark Dynamic 34+
-------------------------- | ---------------------------- | -------------- | ------------------- | ----------------------------------- | ------------- | ------------------ | ----------------
Primary                    | colorPrimary                 | primary40      | system_accent1_600  | system_primary_light                | primary80     | system_accent1_200 | system_primary_dark
On Primary                 | colorOnPrimary               | white          | system_accent1_0    | system_on_primary_light             | primary20     | system_accent1_800 | system_on_primary_dark
Primary Container          | colorPrimaryContainer        | primary90      | system_accent1_100  | system_primary_container_light      | primary30     | system_accent1_700 | system_primary_container_dark
On Primary Container       | colorOnPrimaryContainer      | primary10      | system_accent1_900  | system_on_primary_container_light   | primary90     | system_accent1_100 | system_on_primary_container_dark
Inverse Primary            | colorPrimaryInverse          | primary80      | system_accent1_200  | system_primary_dark                 | primary40     | system_accent1_600 | system_primary_light
Primary Fixed              | colorPrimaryFixed            | primary90      | system_accent1_100  | system_primary_fixed                | primary90     | system_accent1_100 | system_primary_fixed
Primary Fixed Dim          | colorPrimaryFixedDim         | primary80      | system_accent1_200  | system_primary_fixed_dim            | primary80     | system_accent1_200 | system_primary_fixed_dim
On Primary Fixed           | colorOnPrimaryFixed          | primary10      | system_accent1_900  | system_on_primary_fixed             | primary10     | system_accent1_900 | system_on_primary_fixed
On Primary Fixed Variant   | colorOnPrimaryFixedVariant   | primary30      | system_accent1_700  | system_on_primary_fixed_variant     | primary30     | system_accent1_700 | system_on_primary_fixed_variant
Secondary                  | colorSecondary               | secondary40    | system_accent2_600  | system_secondary_light              | secondary80   | system_accent2_200 | system_secondary_dark
On Secondary               | colorOnSecondary             | white          | system_accent2_0    | system_on_secondary_light           | secondary20   | system_accent2_800 | system_on_secondary_dark
Secondary Container        | colorSecondaryContainer      | secondary90    | system_accent2_100  | system_secondary_container_light    | secondary30   | system_accent2_700 | system_secondary_container_dark
On Secondary Container     | colorOnSecondaryContainer    | secondary10    | system_accent2_900  | system_on_secondary_container_light | secondary90   | system_accent2_100 | system_on_secondary_container_dark
Secondary Fixed            | colorSecondaryFixed          | secondary90    | system_accent2_100  | system_secondary_fixed              | secondary90   | system_accent2_100 | system_secondary_fixed
Secondary Fixed Dim        | colorSecondaryFixedDim       | secondary80    | system_accent2_200  | system_secondary_fixed_dim          | secondary80   | system_accent2_200 | system_secondary_fixed_dim
On Secondary Fixed         | colorOnSecondaryFixed        | secondary10    | system_accent2_900  | system_on_secondary_fixed           | secondary10   | system_accent2_900 | system_on_secondary_fixed
On Secondary Fixed Variant | colorOnSecondaryFixedVariant | secondary30    | system_accent2_700  | system_on_secondary_fixed_variant   | secondary30   | system_accent2_700 | system_on_secondary_fixed_variant
Tertiary                   | colorTertiary                | tertiary40     | system_accent3_600  | system_tertiary_light               | tertiary80    | system_accent3_200 | system_tertiary_dark
On Tertiary                | colorOnTertiary              | white          | system_accent3_0    | system_on_tertiary_light            | tertiary20    | system_accent3_800 | system_on_tertiary_dark
Tertiary Container         | colorTertiaryContainer       | tertiary90     | system_accent3_100  | system_tertiary_container_light     | tertiary30    | system_accent3_700 | system_tertiary_container_dark
On Tertiary Container      | colorOnTertiaryContainer     | tertiary10     | system_accent3_900  | system_on_tertiary_container_light  | tertiary90    | system_accent3_100 | system_on_tertiary_container_dark
Tertiary Fixed             | colorTertiaryFixed           | tertiary90     | system_accent3_100  | system_tertiary_fixed               | tertiary90    | system_accent3_100 | system_tertiary_fixed
Tertiary Fixed Dim         | colorTertiaryFixedDim        | tertiary80     | system_accent3_200  | system_tertiary_fixed_dim           | tertiary80    | system_accent3_200 | system_tertiary_fixed_dim
On Tertiary Fixed          | colorOnTertiaryFixed         | tertiary10     | system_accent3_900  | system_on_tertiary_fixed            | tertiary10    | system_accent3_900 | system_on_tertiary_fixed
On Tertiary Fixed Variant  | colorOnTertiaryFixedVariant  | tertiary30     | system_accent3_700  | system_on_tertiary_fixed_variant    | tertiary30    | system_accent3_700 | system_on_tertiary_fixed_variant

<h4>Reference : https://github.com/material-components/material-components-android/blob/master/docs/theming/Color.md?plain=1</h4>

### Dynamic Color Palette

You can setup the dynamic colour palette by modifying this part of code 
```kotlin
@Composable
fun DynamicColorsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
