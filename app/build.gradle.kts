plugins {
	alias(libs.plugins.androidApplication)
	//	alias(libs.plugins.kotlinParcelize)
	alias(libs.plugins.kotlinAndroid)
	alias(libs.plugins.ksp)
	alias(libs.plugins.hilt)
}

android {
	namespace = "david.pokeman.oldmutual"
	compileSdk = 34
	defaultConfig {
		applicationId = "david.pokeman.oldmutual"
		minSdk = 24
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"
		
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
	implementation(project(":authentication"))
	
	implementation(libs.androidx.core.splashscreen)
	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)
	implementation(libs.androidx.activity)
	implementation(libs.androidx.constraintlayout)
	implementation(libs.androidx.palette.ktx)
	
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	
	// Navigation Component
	implementation(libs.androidx.navigation.fragment.ktx)
	implementation(libs.androidx.navigation.ui.ktx)
	
	// Room
	implementation(libs.androidx.room.ktx)
	ksp(libs.androidx.room.compiler)
	
	// DataStore
	implementation(libs.androidx.datastore.preferences)
	
	// Pager
	implementation(libs.androidx.paging.runtime.ktx)
	
	// Compose
	implementation(libs.compose.navigation)
	implementation(libs.compose.runtime)
	implementation(libs.compose.activity)
	implementation(libs.compose.viewmodel)
	implementation(libs.compose.material)
	implementation(libs.compose.ui)
	implementation(libs.compose.ui.graphics)
	implementation(libs.compose.ui.tooling)
	implementation(libs.compose.ui.tooling.preview)
	implementation (libs.androidx.lifecycle.runtime.compose)
	
	// Coroutines
	implementation(libs.kotlinx.coroutines.core)
	implementation(libs.jetbrains.kotlinx.coroutines.android)
	
	// Retrofit
	implementation(libs.retrofit)
	implementation(libs.converter.gson)
	
	// OkHttp3
	implementation(libs.okhttp)
	implementation(libs.logging.interceptor)
	
	// Dagger Hilt
	implementation(libs.hilt.android)
	implementation(libs.hilt.navigation.compose)
	ksp(libs.hilt.compiler)
	ksp(libs.hilt.compiler.androidx)
//	kspTest(libs.hilt.compiler.androidx)
//	kspAndroidTest(libs.hilt.compiler.androidx)
//	testImplementation(libs.hilt.android.testing)
//	androidTestImplementation(libs.hilt.android.testing)
	
	// Coil
	implementation(libs.coil)
	implementation(libs.coilCompose)
	
	// Glide
	implementation(libs.glide)
	annotationProcessor(libs.glide.compiler)
	
	// Moshi
//	implementation(libs.moshi.kotlin)
//	implementation(libs.converter.moshi)
//	ksp(libs.moshi.kotlin.codegen)
}