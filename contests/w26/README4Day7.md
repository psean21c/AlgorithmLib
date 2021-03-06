

Below are the different solutions on the same question of the Day7.. both get 100% score

### Solution by one Russian

```cpp
// Written by a Russian
#pragma GCC diagnostic ignored "-Wunused-result"

#include <cstdio>
#include <vector>
#include <cstdlib>
#include <cassert>

const int MOD = 1000 * 1000 * 1000 + 7;

inline int modAdd(int a, int b) {
	return (a + b) % MOD;
}

inline int modAdd(int a, int b, int c) {
	return modAdd(modAdd(a, b), c);
}

inline int modSub(int a, int b) {
	return (a - b + MOD) % MOD;
}

inline void modInc(int &a) {
	a++;
	if (a == MOD) {
		a = 0;
	}
}

inline int modMul(int a, int b) {
	return int((1LL * a * b) % MOD);
}

inline int modMul(int a, int b, int c) {
	return modMul(modMul(a, b), c);
}

inline int modMul(int a, int b, int c, int d) {
	return modMul(modMul(a, b), modMul(c, d));
}

int modPow(int a, int n) {
	int res = 1;
	while (n > 0) {
		if ((n & 1) != 0) {
			res = modMul(res, a);
			n--;
		} else {
			a = modMul(a, a);
			n >>= 1;
		}
	}
	return res;
}

int modRev(int a) {
	return modPow(a, MOD - 2);
}

int modDiv(int a, int b) {
	return modMul(a, modRev(b));
}

int found[100][100]; // [n][m] -> res, -1 is not filled

int solveSlowest(int n, int m) {
	int count = 0;
	if (n == 1) {
		assert(1 <= m && m <= 62);
		for (long long v1 = 1; v1 < 1LL << m; v1++) {
			modInc(count);
		}
	} else if (n == 2) {
		assert(1 <= m && m <= 30);
		for (int v1 = 1; v1 < 1 << m; v1++) {
			for (int v2 = 1; v2 < 1 << m; v2++) {
				if (v1 != v2 && (v1 ^ v2) != 0) {
					modInc(count);
				}
			}
		}
	} else if (n == 3) {
		assert(1 <= m && m <= 30);
		for (int v1 = 1; v1 < 1 << m; v1++) {
			for (int v2 = 1; v2 < 1 << m; v2++) {
				for (int v3 = 1; v3 < 1 << m; v3++) {
					if (v1 != v2 && v1 != v3 && v2 != v3 && (v1 ^ v2 ^ v3) != 0) {
						modInc(count);
					}
				}
			}
		}
	} else if (n == 4) {
		assert(1 <= m && m <= 30);
		for (int v1 = 1; v1 < 1 << m; v1++) {
			for (int v2 = 1; v2 < 1 << m; v2++) {
				for (int v3 = 1; v3 < 1 << m; v3++) {
					for (int v4 = 1; v4 < 1 << m; v4++) {
						if (v1 != v2 && v1 != v3 && v1 != v4 && v2 != v3 && v2 != v4 && v3 != v4 && (v1 ^ v2 ^ v3 ^ v4) != 0) {
							modInc(count);
						}
					}
				}
			}
		}
	} else if (n == 5) {
		assert(1 <= m && m <= 30);
		for (int v1 = 1; v1 < 1 << m; v1++) {
			for (int v2 = 1; v2 < 1 << m; v2++) {
				for (int v3 = 1; v3 < 1 << m; v3++) {
					for (int v4 = 1; v4 < 1 << m; v4++) {
						for (int v5 = 1; v5 < 1 << m; v5++) {
							if (v1 != v2 && v1 != v3 && v1 != v4 && v1 != v5 && v2 != v3 && v2 != v4 && v2 != v5 && v3 != v4 && v3 != v5 && v4 != v5 && (v1 ^ v2 ^ v3 ^ v4 ^ v5) != 0) {
								modInc(count);
							}
						}
					}
				}
			}
		}
	} else if (n == 6) {
		assert(1 <= m && m <= 30);
		for (int v1 = 1; v1 < 1 << m; v1++) {
			for (int v2 = 1; v2 < 1 << m; v2++) {
				for (int v3 = 1; v3 < 1 << m; v3++) {
					for (int v4 = 1; v4 < 1 << m; v4++) {
						for (int v5 = 1; v5 < 1 << m; v5++) {
							for (int v6 = 1; v6 < 1 << m; v6++) {
								if (
									v1 != v2 && v1 != v3 && v1 != v4 && v1 != v5 && v1 != v6 &&
									v2 != v3 && v2 != v4 && v2 != v5 && v2 != v6 &&
									v3 != v4 && v3 != v5 && v3 != v6 &&
									v4 != v5 && v4 != v6 &&
									v5 != v6 &&
									(v1 ^ v2 ^ v3 ^ v4 ^ v5 ^ v6) != 0
								) {
									modInc(count);
								}
							}
						}
					}
				}
			}
		}
	} else if (n == 7) {
		assert(1 <= m && m <= 30);
		for (int v1 = 1; v1 < 1 << m; v1++) {
			for (int v2 = 1; v2 < 1 << m; v2++) {
				for (int v3 = 1; v3 < 1 << m; v3++) {
					for (int v4 = 1; v4 < 1 << m; v4++) {
						for (int v5 = 1; v5 < 1 << m; v5++) {
							for (int v6 = 1; v6 < 1 << m; v6++) {
								for (int v7 = 1; v7 < 1 << m; v7++) {
									if (
										v1 != v2 && v1 != v3 && v1 != v4 && v1 != v5 && v1 != v6 && v1 != v7 &&
										v2 != v3 && v2 != v4 && v2 != v5 && v2 != v6 && v2 != v7 &&
										v3 != v4 && v3 != v5 && v3 != v6 && v3 != v7 &&
										v4 != v5 && v4 != v6 && v4 != v7 &&
										v5 != v6 && v5 != v7 &&
										v6 != v7 &&
										(v1 ^ v2 ^ v3 ^ v4 ^ v5 ^ v6 ^ v7) != 0
									) {
										modInc(count);
									}
								}
							}
						}
					}
				}
			}
		}
	} else if (n == 8) {
		assert(1 <= m && m <= 30);
		for (int v1 = 1; v1 < 1 << m; v1++) {
			for (int v2 = 1; v2 < 1 << m; v2++) {
				for (int v3 = 1; v3 < 1 << m; v3++) {
					for (int v4 = 1; v4 < 1 << m; v4++) {
						for (int v5 = 1; v5 < 1 << m; v5++) {
							for (int v6 = 1; v6 < 1 << m; v6++) {
								for (int v7 = 1; v7 < 1 << m; v7++) {
									for (int v8 = 1; v8 < 1 << m; v8++) {
										if (
											v1 != v2 && v1 != v3 && v1 != v4 && v1 != v5 && v1 != v6 && v1 != v7 && v1 != v8 &&
											v2 != v3 && v2 != v4 && v2 != v5 && v2 != v6 && v2 != v7 && v2 != v8 &&
											v3 != v4 && v3 != v5 && v3 != v6 && v3 != v7 && v3 != v8 &&
											v4 != v5 && v4 != v6 && v4 != v7 && v4 != v8 &&
											v5 != v6 && v5 != v7 && v5 != v8 &&
											v6 != v7 && v6 != v8 &&
											v7 != v8 &&
											(v1 ^ v2 ^ v3 ^ v4 ^ v5 ^ v6 ^ v7 ^ v8) != 0
										) {
											modInc(count);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	} else if (n == 9) {
		assert(1 <= m && m <= 30);
		for (int v1 = 1; v1 < 1 << m; v1++) {
			for (int v2 = 1; v2 < 1 << m; v2++) {
				for (int v3 = 1; v3 < 1 << m; v3++) {
					for (int v4 = 1; v4 < 1 << m; v4++) {
						for (int v5 = 1; v5 < 1 << m; v5++) {
							for (int v6 = 1; v6 < 1 << m; v6++) {
								for (int v7 = 1; v7 < 1 << m; v7++) {
									for (int v8 = 1; v8 < 1 << m; v8++) {
										for (int v9 = 1; v9 < 1 << m; v9++) {
											if (
												v1 != v2 && v1 != v3 && v1 != v4 && v1 != v5 && v1 != v6 && v1 != v7 && v1 != v8 && v1 != v9 &&
												v2 != v3 && v2 != v4 && v2 != v5 && v2 != v6 && v2 != v7 && v2 != v8 && v2 != v9 &&
												v3 != v4 && v3 != v5 && v3 != v6 && v3 != v7 && v3 != v8 && v3 != v9 &&
												v4 != v5 && v4 != v6 && v4 != v7 && v4 != v8 && v4 != v9 &&
												v5 != v6 && v5 != v7 && v5 != v8 && v5 != v9 &&
												v6 != v7 && v6 != v8 && v6 != v9 &&
												v7 != v8 && v7 != v9 &&
												v8 != v9 &&
												(v1 ^ v2 ^ v3 ^ v4 ^ v5 ^ v6 ^ v7 ^ v8 ^ v9) != 0
											) {
												modInc(count);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	} else {
		assert(false);
	}
	return count;
}

int solveSlow(int n, int m) {
	if (m < 30 && n > (1 << m) - 1) {
		return 0; // the number of piles is greater than the amount of allowed numbers, return zero
	}
	int count = 0;
	if (n == 1) {
		return modSub(modPow(2, m), 1); // the number of values 1 <= x < 2^m
	} else if (n == 2) {
		int cnt1 = modSub(modPow(2, m), 1); // any number
		int cnt2 = modSub(modPow(2, m), 2); // any number except the first
		return modMul(cnt1, cnt2); // just multiply, xor == 0 mean that the numbers are equal but they are distinct
	} else if (n == 3) {
		assert(1 <= m && m <= 30);
		for (int v1 = 1; v1 < 1 << m; v1++) {
			for (int v2 = 1; v2 < 1 << m; v2++) {
				if (v2 != v1) {
					// should not be: v1 ^ v2 ^ v3 == 0
					int except = v1 ^ v2;
					if (except == v1 || except == v2) {
						count = modAdd(count, (1 << m) - 3);
						assert(false); // never happens for n == 3
					} else {
						count = modAdd(count, (1 << m) - 4);
					}
				}
			}
		}
		// printf("n=%d m=%d count=%d\n", n, m, count);
	} else if (n == 4) {
		assert(1 <= m && m <= 30);
		int lost = 0;
		for (int v1 = 1; v1 < 1 << m; v1++) {
			for (int v2 = 1; v2 < 1 << m; v2++) {
				if (v2 != v1) {
					for (int v3 = 1; v3 < 1 << m; v3++) {
						if (v3 != v1 && v3 != v2) {
							// should not be: v1 ^ v2 ^ v3 ^ v4 == 0
							int except = v1 ^ v2 ^ v3;
							if (except == v1 || except == v2 || except == v3 || except == 0) {
								count = modAdd(count, (1 << m) - 4); // only except == 0 happens for n == 4
								lost++;
							} else {
								count = modAdd(count, (1 << m) - 5);
							}
						}
					}
				}
			}
		}
		// printf("n=%d m=%d count=%d lost=%d\n", n, m, count, lost);
	} else if (n == 5) {
		assert(1 <= m && m <= 30);
		int lost = 0;
		int nEx0 = 0;
		int nExEq = 0;
		int nExNe = 0;
		for (int v1 = 1; v1 < 1 << m; v1++) {
			for (int v2 = 1; v2 < 1 << m; v2++) {
				if (v2 != v1) {
					for (int v3 = 1; v3 < 1 << m; v3++) {
						if (v3 != v1 && v3 != v2) {
							for (int v4 = 1; v4 < 1 << m; v4++) {
								if (v4 != v1 && v4 != v2 && v4 != v3) {
									// should not be: v1 ^ v2 ^ v3 ^ v4 ^ v5 == 0
									int except = v1 ^ v2 ^ v3 ^ v4;
									if (except == 0) {
										count = modAdd(count, (1 << m) - 5);
										lost++;
										nEx0++;
									} else if (except == v1 || except == v2 || except == v3 || except == v4) {
										count = modAdd(count, (1 << m) - 5);
										lost++;
										nExEq++;
									} else {
										count = modAdd(count, (1 << m) - 6);
										nExNe++;
									}
								}
							}
						}
					}
				}
			}
		}
		// printf("n=%d m=%d count=%d lost=%d\n", n, m, count, lost);
		// if (m == 3) {
		//	printf("n=%d m=%d nEx0=%d nExEq=%d nExNe=%d\n", n, m, nEx0, nExEq, nExNe);
		// }
	} else if (n == 6) {
		assert(1 <= m && m <= 30);
		int nEx0 = 0;
		int nEx1 = 0;
		int nExEq = 0;
		int nExNe = 0;
		for (int v1 = 1; v1 < 1 << m; v1++) {
			for (int v2 = 1; v2 < 1 << m; v2++) {
				if (v2 != v1) {
					for (int v3 = 1; v3 < 1 << m; v3++) {
						if (v3 != v1 && v3 != v2) {
							for (int v4 = 1; v4 < 1 << m; v4++) {
								if (v4 != v1 && v4 != v2 && v4 != v3) {
									for (int v5 = 1; v5 < 1 << m; v5++) {
										if (v5 != v1 && v5 != v2 && v5 != v3 && v5 != v4) {
											// should not be: v1 ^ v2 ^ v3 ^ v4 ^ v5 ^ v6 == 0
											int except = v1 ^ v2 ^ v3 ^ v4 ^ v5;
											if (except == 0) {
												count = modAdd(count, (1 << m) - 6);
												nEx0++;
											} else if (except == v1) {
												if (m == 3) {
													// printf("except == v1 v1=%d v2=%d v3=%d v4=%d v5=%d\n", v1, v2, v3, v4, v5);
												}
												count = modAdd(count, (1 << m) - 6);
												assert((v2 ^ v3 ^ v4 ^ v5) == 0);
												nEx1++;
												nExEq++;
											} else if (except == v2 || except == v3 || except == v4 || except == v5) {
												count = modAdd(count, (1 << m) - 6);
												nExEq++;
											} else {
												count = modAdd(count, (1 << m) - 7);
												nExNe++;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		// if (m == 3) {
			// printf("n=%d m=%d nEx0=%d nExEq=%d nExNe=%d nEx1=%d\n", n, m, nEx0, nExEq, nExNe, nEx1);
		// }
	} else if (n == 7) {
		assert(1 <= m && m <= 30);
		int nEx0 = 0;
		int nExEq = 0;
		int nExNe = 0;
		for (int v1 = 1; v1 < 1 << m; v1++) {
			for (int v2 = 1; v2 < 1 << m; v2++) {
				if (v2 != v1) {
					for (int v3 = 1; v3 < 1 << m; v3++) {
						if (v3 != v1 && v3 != v2) {
							for (int v4 = 1; v4 < 1 << m; v4++) {
								if (v4 != v1 && v4 != v2 && v4 != v3) {
									for (int v5 = 1; v5 < 1 << m; v5++) {
										if (v5 != v1 && v5 != v2 && v5 != v3 && v5 != v4) {
											for (int v6 = 1; v6 < 1 << m; v6++) {
												if (v6 != v1 && v6 != v2 && v6 != v3 && v6 != v4 && v6 != v5) {
													// should not be: v1 ^ v2 ^ v3 ^ v4 ^ v5 ^ v6 ^ v7 == 0
													int except = v1 ^ v2 ^ v3 ^ v4 ^ v5 ^ v6;
													if (except == 0) {
														count = modAdd(count, (1 << m) - 7);
														nEx0++;
													} else if (except == v1 || except == v2 || except == v3 || except == v4 || except == v5 || except == v6) {
														count = modAdd(count, (1 << m) - 7);
														nExEq++;
													} else {
														count = modAdd(count, (1 << m) - 8);
														nExNe++;
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		// printf("n=%d m=%d nEx0=%d nExEq=%d nExNe=%d\n", n, m, nEx0, nExEq, nExNe);
	} else if (n == 8) {
		assert(1 <= m && m <= 30);
		for (int v1 = 1; v1 < 1 << m; v1++) {
			for (int v2 = 1; v2 < 1 << m; v2++) {
				if (v2 != v1) {
					for (int v3 = 1; v3 < 1 << m; v3++) {
						if (v3 != v1 && v3 != v2) {
							for (int v4 = 1; v4 < 1 << m; v4++) {
								if (v4 != v1 && v4 != v2 && v4 != v3) {
									for (int v5 = 1; v5 < 1 << m; v5++) {
										if (v5 != v1 && v5 != v2 && v5 != v3 && v5 != v4) {
											for (int v6 = 1; v6 < 1 << m; v6++) {
												if (v6 != v1 && v6 != v2 && v6 != v3 && v6 != v4 && v6 != v5) {
													for (int v7 = 1; v7 < 1 << m; v7++) {
														if (v7 != v1 && v7 != v2 && v7 != v3 && v7 != v4 && v7 != v5 && v7 != v6) {
															// should not be: v1 ^ v2 ^ v3 ^ v4 ^ v5 ^ v6 ^ v7 ^ v8 == 0
															int except = v1 ^ v2 ^ v3 ^ v4 ^ v5 ^ v6 ^ v7;
															if (except == v1 || except == v2 || except == v3 || except == v4 || except == v5 || except == v6 || except == v7 || except == 0) {
																count = modAdd(count, (1 << m) - 8);
															} else {
																count = modAdd(count, (1 << m) - 9);
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	} else if (n == 9) {
		assert(1 <= m && m <= 30);
		for (int v1 = 1; v1 < 1 << m; v1++) {
			for (int v2 = 1; v2 < 1 << m; v2++) {
				if (v2 != v1) {
					for (int v3 = 1; v3 < 1 << m; v3++) {
						if (v3 != v1 && v3 != v2) {
							for (int v4 = 1; v4 < 1 << m; v4++) {
								if (v4 != v1 && v4 != v2 && v4 != v3) {
									for (int v5 = 1; v5 < 1 << m; v5++) {
										if (v5 != v1 && v5 != v2 && v5 != v3 && v5 != v4) {
											for (int v6 = 1; v6 < 1 << m; v6++) {
												if (v6 != v1 && v6 != v2 && v6 != v3 && v6 != v4 && v6 != v5) {
													for (int v7 = 1; v7 < 1 << m; v7++) {
														if (v7 != v1 && v7 != v2 && v7 != v3 && v7 != v4 && v7 != v5 && v7 != v6) {
															for (int v8 = 1; v8 < 1 << m; v8++) {
																if (v8 != v1 && v8 != v2 && v8 != v3 && v8 != v4 && v8 != v5 && v8 != v6 && v8 != v7) {
																	// should not be: v1 ^ v2 ^ v3 ^ v4 ^ v5 ^ v6 ^ v7 ^ v8 ^ v9 == 0
																	int except = v1 ^ v2 ^ v3 ^ v4 ^ v5 ^ v6 ^ v7 ^ v8;
																	if (except == v1 || except == v2 || except == v3 || except == v4 || except == v5 || except == v6 || except == v7 || except == v8 || except == 0) {
																		count = modAdd(count, (1 << m) - 9);
																	} else {
																		count = modAdd(count, (1 << m) - 10);
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	} else {
		assert(false);
	}
	return count;
}

int solveFast(int n, int m) {
	if (m < 30 && n > (1 << m) - 1) {
		return 0; // the number of piles is greater than the amount of allowed numbers, return zero
	}
	if (n == 1) {
		return modSub(modPow(2, m), 1); // the number of values 1 <= x < 2^m
	} else if (n == 2) {
		int cnt1 = modSub(modPow(2, m), 1); // any number
		int cnt2 = modSub(modPow(2, m), 2); // any number except the first
		return modMul(cnt1, cnt2); // just multiply, xor == 0 mean that the numbers are equal but they are distinct
	/*
	} else if (n == 3) {
		int cnt1 = modSub(modPow(2, m), 1); // any number
		int cnt2 = modSub(modPow(2, m), 2); // any number except the first
		int cnt3 = modSub(modPow(2, m), 4); // any number except 1, 2 and (v1 ^ v2). (v1 ^ v2) != v1, (v1 ^ v2) != v2
		return modMul(cnt1, cnt2, cnt3);
	} else if (n == 4) {
		int cnt1 = modSub(modPow(2, m), 1); // any number
		int cnt2 = modSub(modPow(2, m), 2); // any number except the first
		int cnt3 = modSub(modPow(2, m), 3); // any number except the first and the second
		// 4th: if v1 ^ v2 ^ v3 == 0 -> v4 is any except v1, v2, v3 else this number is prohibited also. for n = 4 (v1 ^ v2 ^ v3) is not equal to v1, v2, v3
		int all3 = modMul(cnt1, cnt2, cnt3);
		int won3 = solveFast(3, m);
		int lost3 = modSub(all3, won3); // == cnt1 * cnt2
		int fromLost = modMul(lost3, modSub(modPow(2, m), 4));
		int fromWon = modMul(won3, modSub(modPow(2, m), 5));
		return modAdd(fromLost, fromWon);
	} else if (n == 5) {
		int cnt1 = modSub(modPow(2, m), 1);
		int cnt2 = modSub(modPow(2, m), 2);
		int cnt3 = modSub(modPow(2, m), 3);
		int cnt4 = modSub(modPow(2, m), 4);
		// v1 ^ v2 ^ v3 ^ v4 could be equal to v1 or v2 or v3 or v4.
		int nEx0 = solveFast(n - 2, m); // v1 ^ v2 ^ v3 ^ v4 == 0
		int nExEq = modMul(nEx0, n - 1); // v1 ^ v2 ^ v3 ^ v4 is equal to v1 or v2 or v3 or v4
		int all4 = modMul(cnt1, cnt2, cnt3, cnt4);
		int nExNe = modSub(all4, modAdd(nEx0, nExEq));
		// printf("fast n=%d m=%d nEx0=%d nExEq=%d nExNe=%d\n", n, m, nEx0, nExEq, nExNe);
		return modAdd(modMul(modAdd(nEx0, nExEq), modSub(modPow(2, m), 5)), modMul(nExNe, modSub(modPow(2, m), 6)));
	} else if (n == 6) {
		int cnt1 = modSub(modPow(2, m), 1);
		int cnt2 = modSub(modPow(2, m), 2);
		int cnt3 = modSub(modPow(2, m), 3);
		int cnt4 = modSub(modPow(2, m), 4);
		int cnt5 = modSub(modPow(2, m), 5);
		// v1 ^ v2 ^ v3 ^ v4 ^ v5 == 0 and all are different
		int all5 = modMul(modMul(cnt1, cnt2), modMul(cnt3, cnt4, cnt5));
		int nEx0 = modSub(all5, solveFast(n - 1, m));
		int all4 = modMul(cnt1, cnt2, cnt3, cnt4);
		int lost4 = modSub(all4, solveFast(n - 2, m));
		int nExEq = modMul(lost4, modSub(modPow(2, m), 5), 5);
		int nExNe = modSub(all5, modAdd(nEx0, nExEq));
		// printf("fast n=%d m=%d nEx0=%d nExEq=%d nExNe=%d\n", n, m, nEx0, nExEq, nExNe);
		return modAdd(modMul(modAdd(nEx0, nExEq), modSub(modPow(2, m), 6)), modMul(nExNe, modSub(modPow(2, m), 7)));
	} else if (n == 7) {
		int cnt1 = modSub(modPow(2, m), 1);
		int cnt2 = modSub(modPow(2, m), 2);
		int cnt3 = modSub(modPow(2, m), 3);
		int cnt4 = modSub(modPow(2, m), 4);
		int cnt5 = modSub(modPow(2, m), 5);
		int cnt6 = modSub(modPow(2, m), 6);
		int all6 = modMul(modMul(cnt1, cnt2, cnt3), modMul(cnt4, cnt5, cnt6));
		int nEx0 = modSub(all6, solveFast(n - 1, m));
		int all5 = modMul(modMul(cnt1, cnt2), modMul(cnt3, cnt4, cnt5));
		int lost5 = modSub(all5, solveFast(n - 2, m));
		int nExEq = modMul(lost5, modSub(modPow(2, m), 6), 6);
		int nExNe = modSub(all6, modAdd(nEx0, nExEq));
		printf("fast n=%d m=%d nEx0=%d nExEq=%d nExNe=%d\n", n, m, nEx0, nExEq, nExNe);
		return modAdd(modMul(modAdd(nEx0, nExEq), modSub(modPow(2, m), 7)), modMul(nExNe, modSub(modPow(2, m), 8)));
	*/
	} else {
		int pow2m = modPow(2, m);
		std::vector<int> all(1 + n);
		all[0] = 1;
		for (int i = 1; i <= n; i++) {
			all[i] = modMul(all[i - 1], modSub(pow2m, i));
		}
		std::vector<int> win(1 + n);
		for (int i = 1; i <= 2; i++) {
			win[i] = solveFast(i, m);
		}
		std::vector<int> lost(1 + n);
		for (int i = 1; i <= 2; i++) {
			lost[i] = modSub(all[i], win[i]);
		}
		for (int i = 3; i <= n; i++) {
			int nEx0 = lost[i - 1];
			int nExEq = modMul(lost[i - 2], modSub(pow2m, i - 1), i - 1);
			int nExNe = modSub(win[i - 1], nExEq);
			// printf("fast n=%d m=%d nEx0=%d nExEq=%d nExNe=%d\n", i, m, nEx0, nExEq, nExNe);
			win[i] = modAdd(modMul(modAdd(nEx0, nExEq), modSub(pow2m, i)), modMul(nExNe, modSub(pow2m, i + 1)));
			lost[i] = modSub(all[i], win[i]);
		}
		return win.back();
   	}
}

void research() {
	for (int i = 0; i < 100; i++) {
		for (int j = 0; j < 100; j++) {
			found[i][j] = -1;
		}
	}
	{
		int n = 1;
		for (int m = 1; m <= 20; m++) { // ~1 min to 35
			int res = solveSlowest(n, m);
			found[n][m] = res;
			// printf("\tfound[%d][%d] = %d;\n", n, m, res);
		}
	}
	found[1][21] = 2097151;
	found[1][22] = 4194303;
	found[1][23] = 8388607;
	found[1][24] = 16777215;
	found[1][25] = 33554431;
	found[1][26] = 67108863;
	found[1][27] = 134217727;
	found[1][28] = 268435455;
	found[1][29] = 536870911;
	found[1][30] = 73741816;
	found[1][31] = 147483633;
	found[1][32] = 294967267;
	found[1][33] = 589934535;
	found[1][34] = 179869064;
	found[1][35] = 359738129;
	{
		int n = 2;
		for (int m = 1; m <= 10; m++) { // ~1 min to 17
			int res = solveSlowest(n, m);
			found[n][m] = res;
			// printf("\tfound[%d][%d] = %d;\n", n, m, res);
		}
	}
	found[2][11] = 4188162;
	found[2][12] = 16764930;
	found[2][13] = 67084290;
	found[2][14] = 268386306;
	found[2][15] = 73643515;
	found[2][16] = 294770662;
	found[2][17] = 179475851;
	{
		int n = 3;
		for (int m = 1; m <= 7; m++) { // ~1 min to 12
			int res = solveSlowest(n, m);
			found[n][m] = res;
			// printf("\tfound[%d][%d] = %d;\n", n, m, res);
		}
	}
	found[3][8] = 16322040;
	found[3][9] = 132389880;
	found[3][10] = 66416113;
	found[3][11] = 560603072;
	found[3][12] = 602093084;
	{
		int n = 4;
		for (int m = 1; m <= 5; m++) {
			int res = solveSlowest(n, m);
			found[n][m] = res;
			// printf("\tfound[%d][%d] = %d;\n", n, m, res);
		}
	}
	found[4][6] = 14061600;
	found[4][7] = 246046752;
	found[4][8] = 113154052;
	{
		int n = 5;
		for (int m = 1; m <= 4; m++) {
			int res = solveSlowest(n, m);
			found[n][m] = res;
			// printf("\tfound[%d][%d] = %d;\n", n, m, res);
		}
	}
	found[5][5] = 19764360;
	found[5][6] = 830337480;
	found[5][7] = 269703030;
	{
		int n = 6;
		for (int m = 1; m <= 3; m++) {
			int res = solveSlowest(n, m);
			found[n][m] = res;
			// printf("\tfound[%d][%d] = %d;\n", n, m, res);
		}
	}
	found[6][4] = 3402000;
	found[6][5] = 513873360;
	{
		int n = 7;
		for (int m = 1; m <= 3; m++) {
			int res = solveSlowest(n, m);
			found[n][m] = res;
			// printf("\tfound[%d][%d] = %d;\n", n, m, res);
		}
	}
	found[7][4] = 30240000;
	found[7][5] = 836678316;
	{
		int n = 8;
		for (int m = 1; m <= 3; m++) {
			int res = solveSlowest(n, m);
			found[n][m] = res;
			// printf("\tfound[%d][%d] = %d;\n", n, m, res);
		}
	}
	found[8][4] = 241920000;
	{
		int n = 9;
		for (int m = 1; m <= 3; m++) {
			int res = solveSlowest(n, m);
			found[n][m] = res;
			// printf("\tfound[%d][%d] = %d;\n", n, m, res);
		}
	}
	// now solveSlow
	for (int n = 1; n <= 2; n++) {
		for (int m = 1; m < 100; m++) {
			int res = solveSlow(n, m);
			if (found[n][m] == -1) {
				found[n][m] = res;
				// printf("\tfound[%d][%d] = %d;\n", n, m, res);
			}
			if (res != found[n][m]) {
				printf("solveSlow != solveSlowest for n=%d m=%d: slowest=%d slow=%d\n", n, m, found[n][m], res);
			}
			assert(res == found[n][m]);
		}
	}
	{
		int n = 3;
		for (int m = 1; m <= 11; m++) {
			int res = solveSlow(n, m);
			if (found[n][m] == -1) {
				found[n][m] = res;
				printf("\tfound[%d][%d] = %d;\n", n, m, res);
			}
			if (res != found[n][m]) {
				printf("solveSlow != solveSlowest for n=%d m=%d: slowest=%d slow=%d\n", n, m, found[n][m], res);
			}
			assert(res == found[n][m]);
		}
	}
	found[3][13] = 286162677;
	found[3][14] = 167661508;
	found[3][15] = 856108576;
	found[3][16] = 910886972;
	{
		int n = 4;
		for (int m = 1; m <= 7; m++) {
			int res = solveSlow(n, m);
			if (found[n][m] == -1) {
				found[n][m] = res;
				printf("\tfound[%d][%d] = %d;\n", n, m, res);
			}
			if (res != found[n][m]) {
				printf("solveSlow != solveSlowest for n=%d m=%d: slowest=%d slow=%d\n", n, m, found[n][m], res);
			}
			assert(res == found[n][m]);
		}
	}
	found[4][9] = 254058571;
	found[4][10] = 744434791;
	found[4][11] = 872671153;
	{
		int n = 5;
		for (int m = 1; m <= 5; m++) {
			int res = solveSlow(n, m);
			if (found[n][m] == -1) {
				found[n][m] = res;
				printf("\tfound[%d][%d] = %d;\n", n, m, res);
			}
			if (res != found[n][m]) {
				printf("solveSlow != solveSlowest for n=%d m=%d: slowest=%d slow=%d\n", n, m, found[n][m], res);
			}
			assert(res == found[n][m]);
		}
	}
	found[5][8] = 450632976;
	{
		int n = 6;
		for (int m = 1; m <= 4; m++) { // !!! 4
			int res = solveSlow(n, m);
			if (found[n][m] == -1) {
				found[n][m] = res;
				printf("\tfound[%d][%d] = %d;\n", n, m, res);
			}
			if (res != found[n][m]) {
				printf("solveSlow != solveSlowest for n=%d m=%d: slowest=%d slow=%d\n", n, m, found[n][m], res);
			}
			assert(res == found[n][m]);
		}
	}
	found[6][6] = 159573504;
	found[6][7] = 903769436;
	{
		int n = 7;
		for (int m = 1; m <= 4; m++) { // !!! 4
			int res = solveSlow(n, m);
			if (found[n][m] == -1) {
				found[n][m] = res;
				printf("\tfound[%d][%d] = %d;\n", n, m, res);
			}
			if (res != found[n][m]) {
				printf("solveSlow != solveSlowest for n=%d m=%d: slowest=%d slow=%d\n", n, m, found[n][m], res);
			}
			assert(res == found[n][m]);
		}
	}
	found[7][6] = 891796472; // several minutes!
	{
		int n = 8;
		for (int m = 1; m <= 3; m++) {
			int res = solveSlow(n, m);
			if (found[n][m] == -1) {
				found[n][m] = res;
				printf("\tfound[%d][%d] = %d;\n", n, m, res);
			}
			if (res != found[n][m]) {
				printf("solveSlow != solveSlowest for n=%d m=%d: slowest=%d slow=%d\n", n, m, found[n][m], res);
			}
			assert(res == found[n][m]);
		}
	}
	found[8][5] = 80279444; // couple of minutes
	{
		int n = 9;
		for (int m = 1; m <= 3; m++) {
			int res = solveSlow(n, m);
			if (found[n][m] == -1) {
				found[n][m] = res;
				printf("\tfound[%d][%d] = %d;\n", n, m, res);
			}
			if (res != found[n][m]) {
				printf("solveSlow != solveSlowest for n=%d m=%d: slowest=%d slow=%d\n", n, m, found[n][m], res);
			}
			assert(res == found[n][m]);
		}
	}
	// fast!
	int nEq = 0;
	for (int n = 1; n < 100; n++) {
		for (int m = 1; m < 100; m++) {
			if (found[n][m] != -1) {
				int res = solveFast(n, m);
				nEq++;
				if (res != found[n][m]) {
					printf("solveFast != solveSlow for n=%d m=%d: slow=%d fast=%d\n", n, m, found[n][m], res);
				}
				assert(res == found[n][m]);
			}
		}
	}
	fprintf(stderr, "fast=slow %d times\n", nEq);
	// std::exit(0);
}

int main() {
	research();
	int n, m;
	scanf("%d %d", &n, &m);
	printf("%d", solveFast(n, m));
	return 0;
}

```
바로 위의 코드는 러시아인 ,아래는 독일인이 짠 프로그램이다. 얼핏 보기에는 위에 짠 프로그램머가 개념이 없는 것 같지만 그 사람 역시 7-8000 명 개발자들 대회에서 항상 상위 10위 안에 들어가고 종종 1위도 하는 사람이다. 단지 이 문제를 해결하기 위해서 결사적으로 문제를 푼 느낌을 받는다..

### Solution by one German

```python
#Written by a German

import sys
n,m = map(int,sys.stdin.readline().split())

p = 1000000007

def pow_mod(x, y, z):
    number = 1
    while y:
        if y & 1:
            number = number * x % z
        y >>= 1
        x = x * x % z
    return number

S = pow_mod(2,m,p)-1 % p
A1 = 0
A2 = 0
A3 = S
W = S

z1 = pow_mod(2,m,p)
x = z1-1
for i in range(2,n+1):
    x -= 1
    A3 = (i * (S-W) * x)%p
    S = (S*x)%p
    W = (S-A1)
    A1 = (W - A3)
    #A2 = (S-W)
print W%p
```
