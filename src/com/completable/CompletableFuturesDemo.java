package com.completable;

import java.util.concurrent.CompletableFuture;

public class CompletableFuturesDemo {
	public static CompletableFuture<String> getUserEmailAsync() {
		return CompletableFuture.supplyAsync(() -> "email");
	}

	public static CompletableFuture<String> getPlaylistAsync(String email) {
		return CompletableFuture.supplyAsync(() -> "playlist");
	}

	public static void show() {
		getUserEmailAsync()
			.thenCompose(CompletableFuturesDemo::getPlaylistAsync)
			.thenAccept(playlist -> System.out.println(playlist));
	}
}
