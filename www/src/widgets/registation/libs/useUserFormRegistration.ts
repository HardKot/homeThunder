'use client'

import {useForm} from "react-hook-form";

export const useUserFormRegistration = () => {
  const { control, formState: { errors } } = useForm()

  return {
    control, errors
  }
}
