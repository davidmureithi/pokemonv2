plugins {
	alias(libs.plugins.androidLibrary)
	alias(libs.plugins.kotlinAndroid)
}

android {
	namespace = "david.pokeman.authentication"
	compileSdk = 34
	
	defaultConfig {
		minSdk = 24
		
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		consumerProguardFiles("consumer-rules.pro")
	}
	
	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}
	buildFeatures {
		compose = true
	}
	composeOptions {
		kotlinCompilerExtensionVersion = "1.5.10"
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_17
		targetCompatibility = JavaVersion.VERSION_17
	}
	kotlinOptions {
		jvmTarget = "17"
	}
}

dependencies {
	implementation(project(":utilities"))
	
	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	
	// Navigation Component
	implementation(libs.androidx.navigation.fragment.ktx)
	implementation(libs.androidx.navigation.ui.ktx)
	
	// Compose
	implementation(libs.compose.runtime)
	
	implementation(libs.compose.navigation)
	implementation(libs.compose.activity)
	implementation(libs.compose.viewmodel)
	implementation(libs.compose.material)
	implementation(libs.compose.ui)
	implementation(libs.compose.ui.graphics)
	implementation(libs.compose.ui.tooling)
	implementation(libs.compose.ui.tooling.preview)
	
	// Coroutines
	implementation(libs.kotlinx.coroutines.core)
	implementation(libs.jetbrains.kotlinx.coroutines.android)
}