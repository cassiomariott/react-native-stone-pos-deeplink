import { NativeModules, Platform } from 'react-native';
import type { TransactionSetupType, TransactionType } from './types';

const LINKING_ERROR =
  `The package 'react-native-stone-pos-deeplink' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

const StonePosDeeplink = NativeModules.StonePosDeeplink
  ? NativeModules.StonePosDeeplink
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export function multiply(a: number, b: number): Promise<number> {
  return StonePosDeeplink.multiply(a, b);
}

export function makeTransaction(
  {
    installmentCount = 1,
    installmentHasInterest = false,
    ...restOfTransactionSetup
  }: TransactionSetupType
  //progressCallbackEventName: ProgressEventName = 'MAKE_TRANSACTION_PROGRESS'
): Promise<TransactionType> {
  return StonePosDeeplink.makeTransaction(
    {
      installmentCount,
      installmentHasInterest,
      ...restOfTransactionSetup,
    }
    //progressCallbackEventName
  );
}
