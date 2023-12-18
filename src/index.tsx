import { NativeModules, Platform } from 'react-native';
import type { 
  TransactionSetupType, 
  TransactionReprinter, 
  TransactionCancel 
} from './types';

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

export function makeTransaction(
  {
    ...restOfTransactionSetup
  }: TransactionSetupType
): Promise<Boolean> {
  return StonePosDeeplink.makeTransaction(
    {
      ...restOfTransactionSetup
    }
  );
}

export function reprinterTransaction(
  {
    ...restOfTransactionReprinter
  }: TransactionReprinter
): Promise<Boolean> {
  return StonePosDeeplink.reprinterTransaction(
    {
      ...restOfTransactionReprinter
    }
  );
}

export function cancelTransaction(
  {
    ...restOfTransactionCancel
  }: TransactionCancel
): Promise<Boolean> {
  return StonePosDeeplink.cancelTransaction(
    {
      ...restOfTransactionCancel
    }
  );
}
